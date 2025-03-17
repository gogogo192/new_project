# OpenJDK 기반의 공식 이미지 사용
FROM openjdk:17-jdk-slim

# 애플리케이션 실행에 필요한 포트 설정
EXPOSE 8080

# JAR 파일을 컨테이너 내부로 복사
ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]
