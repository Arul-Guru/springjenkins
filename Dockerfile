FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/skilledge-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8008
ENTRYPOINT ["java","-jar","app.jar"]


