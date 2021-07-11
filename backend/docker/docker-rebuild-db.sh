#!/bin/bash
docker container rm -f efficientmvpexample_postgres_1
docker volume rm efficientmvpexample_postgres
docker-compose -f docker-compose-database.yml up -d