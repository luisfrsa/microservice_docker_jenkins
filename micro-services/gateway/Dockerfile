# FROM maven:3.5-jdk-8-alpine as build
# WORKDIR /app
# COPY pom.xml /app
# COPY src /app/src
# RUN mvn clean install


FROM openjdk:8-jdk-alpine
VOLUME /tmp
# COPY --from=build /app/target/gateway-0.0.1-SNAPSHOT.jar app.jar
COPY /target/gateway-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
