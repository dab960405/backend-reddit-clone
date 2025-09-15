# Etapa de construcción
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Copiamos todo el proyecto
COPY . .

# 🔑 Solución: damos permisos al mvnw
RUN chmod +x mvnw

# Construimos el JAR
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
