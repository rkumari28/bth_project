FROM openjdk:21
LABEL authors="ruchikumari"
EXPOSE 9001
ADD target/sportworker:1.0.jar sportworker.jar
ENTRYPOINT ["java", "-jar", "sportworker.jar"]