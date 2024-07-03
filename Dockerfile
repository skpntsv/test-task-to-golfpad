FROM maven:3.8.5-openjdk-17 AS build
COPY ./Course-Handicap-calculation/. /app
WORKDIR /app
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim
COPY --from=build /app/target/Course-Handicap-0.0.1-SNAPSHOT.jar /course-handicap-calculator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/course-handicap-calculator.jar"]
