FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

RUN ls -l /app/target

FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=builder /app/target/cli-starter-spring-klleriston-1.0.0-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "cli-starter-spring-klleriston-1.0.0-SNAPSHOT.jar"]
