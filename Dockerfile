# Folosim o imagine de bază cu OpenJDK 17
FROM openjdk:17-jdk-slim

# Setăm un director de lucru
WORKDIR /app

# Copiem JAR-ul construit în container
COPY target/notification-api-0.0.1-SNAPSHOT.jar notification-service.jar

# Expunem portul 8080 (sau alt port pe care rulează serviciul)
EXPOSE 8080

# Comanda de rulare a aplicației
ENTRYPOINT ["java", "-jar", "notification-service.jar"]
