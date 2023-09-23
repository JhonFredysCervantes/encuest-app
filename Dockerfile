FROM eclipse-temurin:17-jre-alpine

WORKDIR app

ARG JAR_FILE=build/libs/encuestapp-0.0.1.jar
ARG PORT=8080

ENV ENCUESTAPP_DATABASE=encuestapp
ENV ENCUESTAPP_DRIVER=mariadb
ENV ENCUESTAPP_HOST=localhost
ENV ENCUESTAPP_PASSWORD=password
ENV ENCUESTAPP_PORT=3309
ENV ENCUESTAPP_USERNAME=root

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","--server.port=${PORT}","/app.jar"]