# Java Quick Start Project

This repository contains code samples for the Quick Start blog post series.

You can read more about the Quick Start series on the [MongoDB Developer Hub](https://www.mongodb.com/developer/).


# MongoDB Cluster

To get started with MongoDB Atlas and get a free cluster read [this blog post](https://developer.mongodb.com/quickstart/free-atlas-cluster).

# Requirements

- Java 21
- Maven 3.8+

# MongoDB URI

Add MongoDB Atlas Cluster URI in # src/main/resources/application.properties:
```
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@<Cluster>>t/?retryWrites=true&w=majority
```

# Command lines

- Compile: 

```sh
mvn clean compile
```

- Run the `Create` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=create
```

- Run the `Read` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=read
```

- Run the `Update` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=update
```

- Run the `Delete` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=delete
```

- Run the `MappingPOJO` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=mapping
```

