# efficient-mvp-example

[![keep_growing logo](readme-images/logo_250x60.png)](https://keepgrowing.in/)

An example project for presenting efficient MVP design.

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

## Getting Started

To clone this repository, execute the following in the command line:

```bash
$ git clone https://github.com/little-pinecone/efficient-mvp-example
```

You can build the application with:

```bash
$ mvn clean install
```

### Profiles

* `dev` - required for a development environment
* `dbschema` - [saves Hibernate DDL schema](https://keepgrowing.in/tools/save-hibernate-ddl-schema-to-a-file/)
  to `schema.sql` file

## Database

To [run the postgres database locally](https://keepgrowing.in/tools/set-up-a-postgresql-database-with-docker/), use the
attached `docker-compose.yml` file and run:

```
$ docker-compose up -d
```

[Database configuration](https://keepgrowing.in/java/springboot/add-a-postgresql-database-to-your-spring-boot-project/):

* user: `admin`
* password: `admin`
* database name: `efficientmvpexample`

### Migrations

* [Migrations are executed by Flyway](https://keepgrowing.in/java/springboot/add-flyway-migrations-to-your-spring-boot-project/)
  and run automatically on the application startup.

### Dropping database

To create the database from scratch run the following commands in the project directory:

```bash
$ docker container rm -f efficientmvpexample_postgres_1 
$ docker volume rm efficientmvpexample_postgres
$ docker-compose up -d
```

When the application is started again, the migrations are applied on an empty db.

## Code analysis

If you want to generate a SonarQube report locally:

* [Set up SonarQube](https://keepgrowing.in/tools/boost-project-quality-with-sonarqube-local-code-analysis/)
* Run the following command in the project directory:

```bash
$ mvn clean verify sonar:sonar -Pcode-coverage -Dspring.profiles.active=dev
```

* Visit the SonarQube instance that is running on your local machine:
  [http://localhost:9000/about](http://localhost:9000/about) and choose the `efficient-mvp-example` project

## Running tests

Run all tests with the following command in the project directory:

```bash
$ mvn test -Dspring.profiles.active=dev
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [Flyway](https://flywaydb.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [Docker Compose](https://docs.docker.com/compose/)