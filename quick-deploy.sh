#!/bin/bash

# 后端应用快速重新部署脚本
# 仅重新构建和部署后端的 Spring Boot 应用，不涉及数据库重置

set -e

echo "=========================================="
echo "  后端应用快速部署脚本 (Quick Deploy)"
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

# 步骤1: 检查应用包
echo "步骤 1/3: 检查应用包..."
if [ ! -f "$WORK_DIR/medical-mock-server.jar" ]; then
    echo "✗ 错误: medical-mock-server.jar 不存在!"
    echo "  请先将编译好最新的 JAR 文件上传到: $WORK_DIR"
    exit 1
fi
echo "✓ 应用准备完毕 (已检测到 medical-mock-server.jar)"
echo ""

# 步骤2: 构建应用镜像
echo "步骤 2/3: 重新构建应用镜像..."
if [ ! -f "$WORK_DIR/Dockerfile" ]; then
    echo "  Dockerfile 不存在,正在创建默认Dockerfile..."
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

cd $WORK_DIR
echo "  构建Docker新镜像..."
docker build -t medical-mock-server:latest .
echo "✓ 镜像构建成功"
echo ""

# 步骤3: 重启运行应用容器
echo "步骤 3/3: 重新运行应用容器..."
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

echo "  等待服务启动(20秒)..."
for i in {1..20}; do
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
echo "应用日志(最后30行):"
echo "----------------------------------------"
docker logs --tail=30 medical-mock-server
echo "----------------------------------------"
echo ""

echo "服务信息:"
echo "  本地访问: http://127.0.0.1:8081/api"
echo "  外部访问: http://${SERVER_IP}:8081/api"
echo ""
echo "部署完成! (如果 API 未响应可稍等几秒再访问)"
