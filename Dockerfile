
#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/SpringBootBlogDockerized-0.0.1-SNAPSHOT.jar SpringBootBlogDockerized-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/SpringBootBlogDockerized-0.0.1-SNAPSHOT.jar"]