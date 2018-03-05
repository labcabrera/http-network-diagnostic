#!/bin/bash

docker run -i \
  --name http-network-diagnostic \
	-h http-network-diagnostic \
  -p 8080:8080 \
	-t \
	labcabrera/http-network-diagnostic:1.0.0
