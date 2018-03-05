FROM openjdk:8u141-jdk

MAINTAINER Luis Cabrera <lab.cabrera@gmail.com>

ENV APP_NAME http-network-diagnostic
ENV APP_VERSION 1.0.0

VOLUME /tmp
ADD ./build/libs/${APP_NAME}-${APP_VERSION}.war /opt/${APP_NAME}/${APP_NAME}-${APP_VERSION}.war
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /opt/${APP_NAME}/${APP_NAME}-${APP_VERSION}.war

