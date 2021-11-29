FROM maven:3.6.0-jdk-11-slim AS build
COPY src /src
COPY pom.xml .
RUN mvn clean package

FROM openjdk:11-jre-slim
COPY --from=build /target/DegreeConverter-1.0-SNAPSHOT.jar DegreeConverter-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","DegreeConverter-1.0-SNAPSHOT.jar"]