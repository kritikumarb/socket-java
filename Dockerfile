# Use an official Maven image to build the project
FROM maven:3.9.9-eclipse-temurin-22 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download the dependencies
COPY pom.xml .

# Download all dependencies without running the application
RUN mvn dependency:go-offline

# Copy the entire project source code
COPY src ./src

# Package the application as a JAR file
RUN mvn clean package -DskipTests

# Use an official JDK runtime for the final image
FROM eclipse-temurin:22-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/WebSocket-0.0.1-SNAPSHOT.jar /app/WebSocket.jar

# Expose the port the WebSocket will run on
EXPOSE 8080

# Set the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/WebSocket.jar"]
