#!/bin/bash
docker container rm -f efficientmvpexample_app_1
cd ../..
mvn clean package -DskipTests
cd backend/docker
docker-compose -f docker-compose-database.yml -f docker-compose-app.yml up -d --build