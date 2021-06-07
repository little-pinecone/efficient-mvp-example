#!/bin/bash
docker container rm -f efficientmvpexample_app_1
mvn package
cd docker
docker-compose -f docker-compose-minimal.yml -f docker-compose-app.yml up -d --build