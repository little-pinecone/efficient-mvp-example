#!/bin/bash
docker container rm -f efficientmvpexample_app_1
mvn package
docker-compose up -d --build app