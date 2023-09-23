FROM eclipse-temurin:17-jre-alpine
WORKDIR app
ARG JAR_FILE=build/libs/encuestapp-0.0.1.jar
ARG PORT=8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","--server.port=${PORT}","/app.jar"]