# Use a lightweight OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the project inside container
RUN ./mvn clean package -DskipTests || mvn clean package -DskipTests

# Expose the port your app runs on
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/pm-api-0.0.1-SNAPSHOT.jar"]
