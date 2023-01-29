FROM openjdk:18

WORKDIR /app
COPY ./target/takehome-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "takehome-0.0.1-SNAPSHOT.jar"]
