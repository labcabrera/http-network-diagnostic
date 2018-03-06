#!/bin/bash

docker ps -a | grep "http-network-diagnostic" | awk '{print $1}' | xargs docker rm -f

docker images -a | grep "http-network-diagnostic" | awk '{print $3}' | xargs docker rmi -f
