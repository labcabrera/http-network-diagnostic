#!/bin/bash

docker run \
  --interactive \
	--tty \
  --name http-network-diagnostic \
  --hostname http-network-diagnostic \
  --publish 8080:8080 \
  labcabrera/http-network-diagnostic:1.0.0
