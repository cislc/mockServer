#!/bin/bash

# 全新服务器完整部署脚本
# 包含MySQL部署、数据导入、应用构建和运行

set -e

echo "=========================================="
echo "  全新服务器完整部署脚本"
echo "=========================================="
echo ""

# 配置变量
MYSQL_ROOT_PASSWORD="Z2A1GNca393kXPM7n98i"
DB_NAME="medical_mock"
WORK_DIR="$(pwd)"
SERVER_IP=$(hostname -I | awk '{print $1}')

echo "配置信息:"
echo "  工作目录: $WORK_DIR"
echo "  服务器IP: $SERVER_IP"
echo "  数据库名: $DB_NAME"
echo ""

# 步骤1: 部署MySQL
echo "步骤 1/5: 部署MySQL..."
if docker ps | grep -q medical-mysql; then
    echo "  MySQL容器已存在,跳过创建"
else
    echo "  拉取MySQL 8.0镜像..."
    
    # 尝试拉取镜像（如果本地没有）
    if ! docker images | grep -q "mysql.*8.0"; then
        echo "  正在拉取MySQL镜像，请耐心等待..."
        if ! docker pull swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/mysql:8.0; then
            echo "✗ 镜像拉取失败!"
            echo "  请检查网络连接或尝试其他镜像源"
            exit 1
        fi
        echo "✓ 镜像拉取成功"
        
        # 打标签为标准名称
        echo "  标记镜像为 mysql:8.0..."
        docker tag swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/mysql:8.0 mysql:8.0
        echo "✓ 镜像标记完成"
    else
        echo "  MySQL镜像已存在，跳过拉取"
    fi
    
    echo "  创建MySQL容器..."
    docker run -d \
      --name medical-mysql \
      --restart always \
      -p 3306:3306 \
      -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD \
      -e MYSQL_DATABASE=$DB_NAME \
      -e MYSQL_CHARACTER_SET_SERVER=utf8mb4 \
      -e MYSQL_COLLATION_SERVER=utf8mb4_unicode_ci \
      -e TZ=Asia/Shanghai \
      -v mysql-data:/var/lib/mysql \
      mysql:8.0.39
    
    echo "  等待MySQL启动(40秒)..."
    for i in {1..40}; do
        echo -n "."
        sleep 1
    done
    echo ""
fi

# 验证MySQL
echo "  验证MySQL连接..."
for i in {1..10}; do
    if docker exec medical-mysql mysql -uroot -p$MYSQL_ROOT_PASSWORD -e "SELECT 1;" >/dev/null 2>&1; then
        echo "✓ MySQL已就绪"
        break
    fi
    echo "  等待MySQL就绪... ($i/10)"
    sleep 3
done
echo ""

# 步骤2预备: 重新生成排班数据（以当前日期为基准）
echo "步骤 2预备: 重新生成排班Mock数据..."
if ! command -v python3 >/dev/null 2>&1; then
    echo "⚠ 未找到python3，将使用预生成的SQL（排班日期可能不是当前时间）"
elif [ ! -f "$WORK_DIR/deployment/scripts/dept_mapping.json" ]; then
    echo "✗ 错误: deployment/scripts/dept_mapping.json 不存在，无法重新生成排班数据!"
    echo "  请将 dept_mapping.json 上传到: $WORK_DIR/deployment/scripts/"
    echo "  将使用预生成的SQL（排班日期可能不是当前时间）"
else
    echo "  使用python3重新生成排班SQL（基准日期: $(date +%Y-%m-%d)）..."
    python3 $WORK_DIR/deployment/scripts/generate_normalized_sql.py
    echo "✓ 排班数据已按当前日期重新生成"
fi
echo ""

# 步骤2: 初始化数据库 (表结构与Mock数据)
echo "步骤 2/4: 初始化数据库..."
if [ -f "$WORK_DIR/deployment/db/medical_mock_init.sql" ]; then
    echo "  清理并导入数据库同步脚本..."
    docker exec -i -e MYSQL_PWD=$MYSQL_ROOT_PASSWORD medical-mysql mysql \
      -uroot \
      --default-character-set=utf8mb4 \
      $DB_NAME < $WORK_DIR/deployment/db/medical_mock_init.sql
    echo "✓ 数据库初始化成功"
else
    echo "✗ 错误: deployment/db/medical_mock_init.sql 不存在!"
    exit 1
fi
echo ""

# 步骤4: 构建应用镜像
echo "步骤 4/5: 构建应用镜像..."
if [ ! -f "$WORK_DIR/medical-mock-server.jar" ]; then
    echo "✗ 错误: medical-mock-server.jar 不存在!"
    echo "  请先上传JAR文件到: $WORK_DIR"
    exit 1
fi

if [ ! -f "$WORK_DIR/Dockerfile" ]; then
    echo "  Dockerfile不存在,创建默认Dockerfile..."
    cat > $WORK_DIR/Dockerfile << 'DOCKERFILE_EOF'
FROM swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/openjdk:8-jre-alpine

WORKDIR /app

COPY medical-mock-server.jar app.jar

ENV TZ=Asia/Shanghai
ENV JAVA_OPTS="-Xms512m -Xmx1024m -XX:+UseG1GC"

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/api/search/department/info || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
DOCKERFILE_EOF
fi

echo "  构建Docker镜像..."
cd $WORK_DIR
docker build -t medical-mock-server:latest .
echo "✓ 镜像构建成功"
echo ""

# 步骤5: 运行应用容器
echo "步骤 5/5: 运行应用容器..."

# 停止并删除旧容器
if docker ps -a | grep -q medical-mock-server; then
    echo "  停止旧容器..."
    docker stop medical-mock-server 2>/dev/null || true
    docker rm medical-mock-server 2>/dev/null || true
fi

echo "  启动新容器..."
docker run -d \
  --name medical-mock-server \
  --restart always \
  -p 8081:8080 \
  -e SPRING_DATASOURCE_URL="jdbc:mysql://${SERVER_IP}:3306/${DB_NAME}?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true" \
  -e SPRING_DATASOURCE_USERNAME=root \
  -e SPRING_DATASOURCE_PASSWORD=$MYSQL_ROOT_PASSWORD \
  -e TZ=Asia/Shanghai \
  medical-mock-server:latest

echo "  等待服务启动(40秒)..."
for i in {1..40}; do
    echo -n "."
    sleep 1
done
echo ""
echo "✓ 应用启动成功"
echo ""

# 验证部署
echo "=========================================="
echo "  部署验证"
echo "=========================================="
echo ""

echo "容器状态:"
docker ps | grep medical
echo ""

echo "应用日志(最后30行):"
echo "----------------------------------------"
docker logs --tail=30 medical-mock-server
echo "----------------------------------------"
echo ""

# 健康检查
echo "健康检查:"
sleep 5
HEALTH_STATUS=$(docker inspect --format='{{.State.Health.Status}}' medical-mock-server 2>/dev/null || echo "no-healthcheck")
echo "  状态: $HEALTH_STATUS"
echo ""

# API测试
echo "API测试:"
sleep 5
echo "  测试接口: /api/search/department/schedule"
TEST_RESULT=$(curl -s -X POST http://127.0.0.1:8081/api/search/department/schedule \
  -H "Content-Type: application/json" \
  -d '{"DepartmentCode":"DEPT002"}' | head -c 200)

if [ -n "$TEST_RESULT" ]; then
    echo "✓ API响应正常"
    echo "  响应预览: ${TEST_RESULT}..."
else
    echo "⚠ API未响应,请检查日志"
fi
echo ""

echo "=========================================="
echo "  部署完成!"
echo "=========================================="
echo ""
echo "服务信息:"
echo "  本地访问: http://127.0.0.1:8081/api"
echo "  外部访问: http://${SERVER_IP}:8081/api"
echo ""
echo "测试命令:"
echo "  curl http://127.0.0.1:8081/api/search/department/schedule \\"
echo "    -H 'Content-Type: application/json' \\"
echo "    -d '{\"DepartmentCode\":\"DEPT002\"}'"
echo ""
echo ""
