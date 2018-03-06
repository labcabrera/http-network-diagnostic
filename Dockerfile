
FROM openjdk:8u141-jdk

MAINTAINER Luis Cabrera <lab.cabrera@gmail.com>

ENV APP_NAME http-network-diagnostic
ENV APP_VERSION 1.0.4-SNAPSHOT
ENV JAVA_OPTS=""

ADD ./build/libs/*.jar /opt/${APP_NAME}/

ENTRYPOINT exec java $JAVA_OPTS -jar /opt/${APP_NAME}/${APP_NAME}-$APP_VERSION.jar

