FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /cardbuilder
COPY pom.xml .
COPY src ./src
RUN mvn clean package
FROM openjdk:17-slim
WORKDIR /cardbuilder
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","./app.jar"]