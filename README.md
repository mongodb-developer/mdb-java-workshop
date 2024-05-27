# Java Quick Start Project

This repository contains code samples for the Quick Start blog post series.

You can read more about the Quick Start series on the [MongoDB Developer Hub](https://www.mongodb.com/developer/).


# MongoDB Cluster

To get started with MongoDB Atlas and get a free cluster read [this blog post](https://developer.mongodb.com/quickstart/free-atlas-cluster).

# Requirements

- Java 21
- Maven 3.8+


# Command lines

- Compile: 

```sh
mvn clean compile
```

## Session 1

### Application.properties

Add MongoDB Atlas  URI in # src/main/resources/application.properties:
```
spring.data.mongodb.uri=mongodb+srv://<user>:<password>@<Cluster>/?retryWrites=true&w=majority
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

## Session 2
For this session make sure to switch to the `sample_supplies` database in your `application.properties`.

- Run the `TotalSalesByLocationService` class:

```sh
 mvn spring-boot:run -Dspring-boot.run.arguments=total-sales-by-location
```

- Run the `AverageCustomerSatisfactionService` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=average-customer-satisfaction
```

- Run the `AverageItemPricePerStoreService` class:
```sh
mvn spring-boot:run -Dspring-boot.run.arguments=average-item-price-per-store
```

- Run the `CountDistinctCustomersService` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments=count-distinct-customers
```

- Run the `TotalSalesByDayOfWeekService` class:
```sh
mvn spring-boot:run -Dspring-boot.run.arguments=total-sales-by-day-of-week
```

- Run the `SalesPerformanceService` class:
```sh
mvn spring-boot:run -Dspring-boot.run.arguments=sales-performance
```

- Run the `RevenueByLocationService` class:
```sh
mvn spring-boot:run -Dspring-boot.run.arguments=revenue-by-location
```

## Session 3

### Application.properties

Add the MongoDB Atlas URI in # src/main/resources/application.properties:
```
mongodb.uri=mongodb+srv://<user>:<password>@<Cluster>/?retryWrites=true&w=majority
```

### Transactions

Always start the `ChangeStreams` class in the `transactions` package first because it creates the `product` collection with the required JSON Schema. See the related blog post.

- Run the `ChangeStreams` class:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments="change-streams"
```

- Run the `Transactions` class in a separate terminal:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments="transactions"
```

### Client Side Encryption

- Run the `ClientSideFieldLevelEncryption` class:
```sh

mvn spring-boot:run -Dspring-boot.run.arguments="csfle"
```
