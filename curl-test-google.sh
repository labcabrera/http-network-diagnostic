#!/bin/bash

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "proxyHost": "proxytal", \ 
   "proxyPassword": "Mapfre14", \ 
   "proxyPort": 80, \ 
   "proxyUsername": "LBARRA1", \ 
   "targetHost": "www.google.es", \ 
   "targetPort": 443, \ 
   "targetSchema": "https", \ 
   "unsafeSsl": true, \ 
   "uri": "/" \ 
 }' http://localhost:8080/api/diagnostic/ping