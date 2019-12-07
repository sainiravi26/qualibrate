FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
COPY qualibrate-service/target/qualibrate-service-0.0.1-SNAPSHOT.jar /opt/app/qualibrate-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app/qualibrate-service.jar