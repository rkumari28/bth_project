FROM openjdk:21
LABEL authors="ruchikumari"
EXPOSE 8080
ADD target/sportapp:1.0.jar sportapp.jar
ENTRYPOINT ["java", "-jar", "sportapp.jar"]