#!/bin/bash
cd docker
docker-compose -f docker-compose-minimal.yml -f docker-compose-app.yml -f docker-compose-monitoring.yml up -d