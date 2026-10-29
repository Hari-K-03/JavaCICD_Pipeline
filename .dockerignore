
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/java-cicd-demo-1.0.0.jar app.jar

ENV PORT=8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
