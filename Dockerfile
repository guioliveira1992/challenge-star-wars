FROM openjdk:8-jdk-alpine
COPY target/challenge-star-war-0.0.1-SNAPSHOT.jar challenge-star-war-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/challenge-star-war-0.0.1-SNAPSHOT.jar"]