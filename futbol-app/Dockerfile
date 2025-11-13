# Etapa 1: Construir el proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Copia los archivos del proyecto
COPY . .

# Construye el proyecto (genera el JAR)
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen final con Java
FROM eclipse-temurin:17-jre-alpine

# Copia el JAR generado desde la etapa anterior
COPY --from=builder target/futbol-app-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8093
EXPOSE 8093

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8093"]