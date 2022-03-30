FROM openjdk:11
RUN apt-get update && apt-get -y install cron
ADD target/challenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]