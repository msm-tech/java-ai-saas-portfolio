# Build stage - uses Maven 3.9.9 with Temurin 17 (close to your local 3.9.15)
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run stage - uses Temurin 17 JRE (slim version)
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/first-app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT["java", "-jar", "app.jar"]