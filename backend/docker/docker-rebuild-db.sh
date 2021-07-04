#!/bin/bash
docker container rm -f efficientmvpexample_postgres_1
docker volume rm efficientmvpexample_postgres
docker-compose up -d postgres