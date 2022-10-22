FROM openjdk:8-jdk-alpine
COPY target/UnitTesting-1.0-SNAPSHOT.jar UnitTesting-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/UnitTesting-1.0-SNAPSHOT.jar"]
