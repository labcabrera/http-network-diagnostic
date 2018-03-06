#!/bin/bash

function prop {
  grep $1 gradle.properties | cut -d "=" -f2
}

APP_VERSION=$(prop 'version')

docker run \
  --interactive \
  --tty \
  --name http-network-diagnostic \
  --hostname http-network-diagnostic \
  --publish 8443:8443 \
  labcabrera/http-network-diagnostic:${APP_VERSION}
