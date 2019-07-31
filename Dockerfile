FROM openjdk:8-jdk-alpine

WORKDIR /movievideo

# boot gradle로 빌드하기 위해 모든 소스 카피
COPY . ./
RUN ["./gradlew", "build"]
# 실행
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/movievideo/build/libs/movievideo-0.0.1-SNAPSHOT.jar"]