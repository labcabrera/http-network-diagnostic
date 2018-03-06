#!/bin/bash

openssl \
  req \
  -newkey rsa:2048 \
  -nodes -keyout ./src/main/resources/key.pem \
  -x509 \
  -days 365 \
  -out ./src/main/resources/certificate.pem

openssl \
  pkcs12 \
  -inkey ./src/main/resources/key.pem \
  -in ./src/main/resources/certificate.pem \
  -export \
  -out ./src/main/resources/certificate.p12