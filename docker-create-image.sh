#!/bin/bash

function prop {
  grep $1 gradle.properties | cut -d "=" -f2
}

APP_VERSION=$(prop 'version')

echo "Building image $APP_VERSION"

docker build \
  -f Dockerfile \
  -t labcabrera/http-network-diagnostic:${APP_VERSION} .
