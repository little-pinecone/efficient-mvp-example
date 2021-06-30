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

# Table of contents
* [Getting Started](#getting-started)
    * [Spring Security](#getting-started-spring-security")
    * [Profiles](#getting-started-profiles")
* [Setting up a local environment](#local-env-setup)
    * [Backend](#local-env-setup-backend)
        * [Prerequisites](#local-env-setup-backend-prerequisites)
        * [Preparing dependencies](#local-env-setup-backend-dependencies)
* [Working with the application](#working-with-app)  
    * [Database](#working-with-app-database)
        * [Migrations](#working-with-app-database-migrations)
        * [Initializing database](#working-with-app-database-init)
        * [Dropping database](#working-with-app-database-drop)
    * [Api documentation](#working-with-app-api-docs)
    * [Monitoring](#working-with-app-monitoring)
        * [Actuator](#working-with-app-monitoring-actuator)
        * [Prometheus](#working-with-app-monitoring-prometheus)
        * [Grafana](#working-with-app-monitoring-grafana)
        * [Logs](#working-with-app-monitoring-logs)
    * [Running tests](#working-with-app-running-tests)
    * [Generating client code](#working-with-generate-client)
* [SonarQube analysis](#sonar-analysis)
* [Building artifacts for deployment](#deployment)


<a name="getting-started"></a>
# Getting Started

This section contains an introduction to the project.

To clone this repository, execute the following in the command line:

```shell
git clone https://github.com/little-pinecone/efficient-mvp-example
```

You can build the application with:

```shell
mvn clean install
```

<a name="getting-started-spring-security"></a>
## Spring security

The application uses [Spring Boot security starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security).
The default credentials are specified in the [application-dev.properties](src/main/resources/application-dev.properties) file:

* `username` admin
* `password` admin

<a name="getting-started-profiles"></a>
## Profiles

* `dev` - required for a development environment for establishing a database connection, default credentials, etc.
* `dbschema` - [saves Hibernate DDL schema](https://keepgrowing.in/tools/save-hibernate-ddl-schema-to-a-file/)
  to `schema.sql` file
* `init` - enables data initialization

<a name="local-env-setup"></a>
# Setting up a local environment

This section contains details of setting up a working dev environment.

<a name="local-env-setup-backend"></a>
## Backend

<a name="local-env-setup-backend-prerequisites"></a>
### Prerequisites

* JDK 13+
* [Maven](https://maven.apache.org/) (or you can use `mvnw` provided in the project)
* [Docker](https://www.docker.com/)
* [Docker Compose](https://docs.docker.com/compose/)

<a name="local-env-setup-backend-dependencies"></a>
### Preparing dependencies

This section contains commands that set up the working development environment that allows you to run the application.

#### Minimal

To start minimal dependencies:
```shell
cd docker
docker-compose -f docker-compose-minimal.yml up -d 
```

#### Dev

To start minimal and dev dependencies:
```shell
cd docker
docker-compose up -d 
```

or run the bash script attached to the project:
```shell
./docker-dev.sh
```

#### Shutting down

To shut down started dependencies:
```shell
cd docker
docker-compose down
```

<a name="working-with-app"></a>
# Working with the application

Make sure to run the application with the `dev` and `init` profiles during development. Otherwise, some configuration may be incorrect.

<a name="working-with-app-database"></a>
## Database

[Specification of the docker container for the database](https://keepgrowing.in/tools/set-up-a-postgresql-database-with-docker/) can be found in the `docker-compose-minimal.yml`.

Default [database configuration](https://keepgrowing.in/java/springboot/add-a-postgresql-database-to-your-spring-boot-project/):
* user: `admin`
* password: `admin`
* database name: `efficientmvpexample`

<a name="working-with-app-database-migrations"></a>
### Migrations

* [Migrations are executed using Flyway](https://keepgrowing.in/java/springboot/add-flyway-migrations-to-your-spring-boot-project/)
  and run automatically on application startup.

<a name="working-with-app-database-init"></a>
### Initializing database

1. Run the application with profile `init`.
2. Perform a `GET` request to the `http://localhost:8080/api/init` endpoint. Application initializes database with fake
   random values and returns the `seed` used for random data generation.
3. You can pass the `seed` as a request parameter, e.g. `http://localhost:8080/api/init?seed=9876` to get the same
   values.
4. Every initialization clears the database and restarts indexes before generating new records.

<a name="working-with-app-database-drop"></a>
### Dropping database

To create the database from scratch run the following commands in the project directory:

```shell
docker container rm -f efficientmvpexample_postgres_1 
docker volume rm efficientmvpexample_postgres
cd docker
docker-compose up -d postgres
```

or run the bash script attached to the project:
```shell
./docker-rebuild-db.sh
```

When the application is started again, the migrations are applied on the empty db.

<a name="api-docs"></a>
## API documentation

* The Swagger UI page: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* The OpenAPI description in json format is available at the following url: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
* The Postman collection for this project: [postman_collection.json](postman/efficient-mvp-example.postman_collection.json)  

<a name="working-with-app-monitoring"></a>
## Monitoring

Monitoring dependencies are available when you start services with:

```shell
cd docker
docker-compose -f docker-compose-minimal.yml -f docker-compose-app.yml -f docker-compose-monitoring.yml up -d
```

or run the bash script attached to the project:
```shell
./docker-staging.sh
```

That means that **you can't monitor a project run from IntelliJ (not through Docker)**.

The default credentials are specified in the [Spring security](#spring-security) section.

<a name="working-with-app-monitoring-actuator"></a>
### Actuator

* Actuator endpoints: [http://localhost:8080/actuator](http://localhost:8080/actuator)

<a name="working-with-app-monitoring-prometheus"></a>
### Prometheus
* Prometheus targets: [http://localhost:9090/targets](http://localhost:9090/targets)

<a name="working-with-app-monitoring-grafana"></a>
### Grafana
* Grafana dashboards: [http://localhost:3000/dashboards](http://localhost:3000/dashboards), the JVM(Micrometer) dashboard should be available by default.
* Grafana datasources: [http://localhost:3000/datasources](http://localhost:3000/datasources), the Prometheus datasource should be available by default.

<a name="working-with-app-monitoring-logs"></a>
### Logs

Application logs are available through Grafana Explore: [http://localhost:3000/explore](http://localhost:3000/explore?orgId=1&left=%5B%22now-1h%22,%22now%22,%22Loki%22,%7B%7D%5D), the [Loki](https://grafana.com/oss/loki/) datasource should be available by default.
Example queries:
  
* search by process: `{job="app"}|="[http-nio-8080-exec-1]"`
* count errors from the last 5 minutes: `count_over_time({job="app"} |= "ERROR" [5m])`
* search by time`{job="app"} |~ "2021-05-28 13:07"`

<a name="working-with-app-running-tests"></a>
## Running tests

Run unit tests with the following command in the project directory:

```shell
mvn test
```

Run all tests with the following command in the project directory:

```shell
mvn verify
```

<a name="working-with-app-generate-client"></a>
## Generating client code

To run client code generation using the `openapi-generator-maven-plugin` execute the follwing command:

```shell
mvn clean verify -Pangular -DskipTests
```

The application will be started so that API specification can be obtained from the open api endpoint. 
Therefore, the maven configuration for the `angular` profile starts the application with the profile `dev` and requires a connection to the db.

Remember to add the spring active profile if the pom file changes:
```shell
mvn clean verify -Pangular -Dspring.profiles.active=dev -DskipTests
```

<a name="sonar-analysis"></a>
# SonarQube analysis

This section describes how to generate a [SonarQube report locally]((https://keepgrowing.in/tools/boost-project-quality-with-sonarqube-local-code-analysis/)).

Default SonarQube credentials:
* user: `admin`
* password: `admin`

Once the SonarQube is running, log in and **change the password**. You'll need to use your sonar credentials when runnig the command listed below.
    
To generate the report:

* Make sure to run services defined in the `docker-compose-dev.yml` file.
* Visit the SonarQube instance that is running on your local machine: [http://localhost:9000](http://localhost:9000) and set up a new password.
* Run the following command in the project directory:

```shell
mvn clean verify sonar:sonar -Pcode-coverage -Dspring.profiles.active=dev -Dsonar.login=admin -Dsonar.password=yourpassword
```

* Visit the [Projects](http://localhost:9000/projects) page and choose the project.
  
<a name="deployment"></a>
# Building artifacts for deployment

```shell
clean package
```

This will create a `.jar` file in the `target` folder

<a name="build-with"></a>
# Built With

* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)
* [Flyway](https://flywaydb.org/)
* [PostgreSQL](https://www.postgresql.org/)
* [Docker Compose](https://docs.docker.com/compose/)
* [springdoc-openapi](https://springdoc.org/)
* [Dummy4j](https://daniel-frak.github.io/dummy4j/)
* [Testcontainers](https://www.testcontainers.org/)