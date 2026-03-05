FROM swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/openjdk:8-jre-alpine

LABEL maintainer="medical-mock-server"
LABEL description="Medical Mock Server Deployment"

WORKDIR /app

# 复制已打包的JAR文件
COPY medical-mock-server.jar app.jar

# 设置时区
ENV TZ=Asia/Shanghai

# 暴露端口
EXPOSE 8080

# JVM参数优化
ENV JAVA_OPTS="-Xms512m -Xmx1024m -XX:+UseG1GC -XX:MaxGCPauseMillis=200"

# 健康检查
HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/api/search/department/info || exit 1

# 启动应用
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
