#FROM openjdk:11-slim-stretch
#EXPOSE 8080
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:17-jdk-slim
EXPOSE 8080

# JAR_FILE 인자를 받도록 설정 (기본값 설정 가능)
ARG JAR_FILE

# JAR 파일을 컨테이너에 복사
COPY ${JAR_FILE} app.jar

# 실행 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]
