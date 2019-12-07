FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
COPY target/qualibrate-service-*.jar /opt/app/qualibrate-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/app/qualibrate-service.jar