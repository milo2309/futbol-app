# Usa una imagen base con OpenJDK 17
FROM eclipse-temurin:17-jre-alpine

# Copia el JAR generado por Maven
COPY target/futbol-app-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8093
EXPOSE 8093

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8093"]