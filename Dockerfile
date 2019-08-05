FROM openjdk:12
ARG DISTRIBUTION_PATH=build
COPY ${DISTRIBUTION_PATH}/libs /app/bin
ENTRYPOINT ["app/bin/greet"]