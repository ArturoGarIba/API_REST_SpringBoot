FROM openjdk:17-jdk-alpine
WORKDIR /apirest
COPY target/ApiRest-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]