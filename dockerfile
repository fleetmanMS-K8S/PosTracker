FROM openjdk:8-jdk-alpine
COPY micro4possim-0.0.1-SNAPSHOT.jar tracker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","tracker.jar"]