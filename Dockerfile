# Etapa de compilación
FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app
COPY . .

# Usamos Maven Wrapper incluido en tu repo
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar el JAR generado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
