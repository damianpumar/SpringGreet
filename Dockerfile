FROM openjdk:12
ARG DISTRIBUTION_PATH=build/libs/greet-0.0.1-SNAPSHOT.jar
COPY ${DISTRIBUTION_PATH} /app/bin/
ENTRYPOINT ["java", "-jar", "/app/bin/greet-0.0.1-SNAPSHOT.jar"]