FROM maven:3.5-jdk-8-alpine as build
#CMD apk --no-cache bash
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn clean install


FROM openjdk:8-jdk-alpine
VOLUME /tmp
#ADD target/*.jar app.jar
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
