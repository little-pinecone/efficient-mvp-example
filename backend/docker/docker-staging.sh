#!/bin/bash
docker-compose -f docker-compose-database.yml -f docker-compose-app.yml -f docker-compose-monitoring.yml up -d