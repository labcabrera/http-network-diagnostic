#!/bin/bash

function prop {
  grep $1 gradle.properties | cut -d "=" -f2
}

APP_VERSION=$(prop 'version')
APP_PORT=9009

docker run \
  --interactive \
  --tty \
  --name http-network-diagnostic \
  --hostname http-network-diagnostic \
  --publish ${APP_PORT}:${APP_PORT} \
  labcabrera/http-network-diagnostic:${APP_VERSION}
