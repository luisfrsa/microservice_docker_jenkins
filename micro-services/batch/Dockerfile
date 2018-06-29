FROM openjdk:8-jdk-alpine
#CMD apk add --no-cache bash
VOLUME /tmp
COPY /target/batch-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
