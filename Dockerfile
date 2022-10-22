FROM openjdk:8-jdk-alpine
COPY target/UnitTesting-1.0.jar UnitTesting-1.0.jar
ENTRYPOINT ["java","-jar","/UnitTesting-1.0.jar"]
