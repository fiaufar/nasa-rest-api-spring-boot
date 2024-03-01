#FROM ubuntu:latest
#LABEL authors="fiaufar"
#
#ENTRYPOINT ["top", "-b"]

#FROM maven:3.9.6
#COPY . .

#RUN mvn clean install

#CMD mvn spring-boot:run

FROM maven:3.9.6-amazoncorretto-21-al2023 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

#RUN mvn -B dependency:go-offline
#RUN mvn clean package -DskipTests
RUN mvn clean install
RUN mv target/*.jar target/application.jar

FROM openjdk:21-slim
#FROM openjdk:21-rc-slim

COPY --from=build /app/target/application.jar .

CMD ["java", "-jar", "application.jar"]
