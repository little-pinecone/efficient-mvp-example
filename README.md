# efficient-mvp-example

[![keep_growing logo](readme-images/logo_250x60.png)](https://keepgrowing.in/)

## Code analysis

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=alert_status)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=bugs)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=coverage)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=code_smells)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=little-pinecone_efficient-mvp-example&metric=sqale_index)](https://sonarcloud.io/dashboard?id=little-pinecone_efficient-mvp-example)

![GitHub](https://img.shields.io/github/license/little-pinecone/efficient-mvp-example)

# About this project

This is an example project for presenting efficient MVP design.
You can find posts related to the tools and techniques used in this project on [keepgrowing.in](https://keepgrowing.in/?s=efficient-mvp-example).

# Getting started
First, [clone](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github/cloning-a-repository) this repository.

Then, build it locally with:

```shell
mvn clean install
```

In order to run the application visit the [Setting up a local environment](https://github.com/little-pinecone/efficient-mvp-example/wiki/Setting-up-a-local-environment) page on Wiki to learn how to start all required dependencies.

# Resources

* [Wiki](https://github.com/little-pinecone/efficient-mvp-example/wiki) – the project documentation.

# Features

* This is a [multi-module application that can be built with Maven as one project](https://keepgrowing.in/java/springboot/integrate-angular-with-a-spring-boot-project/).
* The local environment is fully dockerized. You won't need to install any dependencies on your machine if you already use [Docker Compose](https://docs.docker.com/compose/).
* Integration tests are run with [Testcontainers](https://www.testcontainers.org/).
* You'll find here a [dockerized PostgreSQL database](https://keepgrowing.in/tools/set-up-a-postgresql-database-with-docker/) that works with the application wihtout any additional configuration. The included migrations are executed against the database on the application start up.
* The database can be [automatically populated with fake data](https://keepgrowing.in/tools/how-i-enhanced-my-project-by-generating-custom-fake-data-with-dummy4j/).
* You can test the endpoints exposed by the API with Swagger UI and use the provided [OpenAPI 3 specification](https://keepgrowing.in/java/springboot/easy-openapi-3-specification-for-your-spring-boot-api/).
* The monitoring stack with [Prometheus, Grafana](https://keepgrowing.in/tools/how-to-set-up-grafana-with-docker-and-connect-it-to-prometheus/) and Loki is dockerized and ready to use.
* The [client code is automatically generated](https://codesoapbox.dev/generate-client-code-from-spring-boot-using-maven/) and available for the Angular application.
* The fronted module has [Bootstrapv 5+ and ng-bootstrap](https://keepgrowing.in/angular/how-to-add-bootstrap-to-your-angular-project-with-ng-bootstrap/) already installed and configured.
