# Java Quick Start Project

This repository contains code samples for the Quick Start blog post series.

You can read more about the Quick Start series on the [MongoDB Developer Hub](https://www.mongodb.com/developer/).

- [MongoDB & Java - CRUD Operations Tutorial](https://www.mongodb.com/developer/languages/java/java-setup-crud-operations/)
- [Java - Mapping POJOs](https://www.mongodb.com/developer/languages/java/java-mapping-pojos/)
- [Java - Aggregation Pipeline](https://www.mongodb.com/developer/languages/java/java-aggregation-pipeline/)

# MongoDB Cluster

To get started with MongoDB Atlas and get a free cluster read [this blog post](https://developer.mongodb.com/quickstart/free-atlas-cluster).

# Requirements

- Java 21
- Maven 3.8/3.9

# Command lines

- Compile: 

```sh
mvn clean compile
```

- Run the `HelloMongoDB` class: 

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.HelloMongoDB"
```
- Run the `Connection` class: 

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Connection" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```

- Run the `Create` class:

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Create" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```

- Run the `Read` class:

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Read" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```

- Run the `Update` class:

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Update" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```

- Run the `Delete` class:

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Delete" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```

- Run the `MappingPOJO` class:

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.MappingPOJO" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```

- Run the `AggregationFramework` class:

```sh
mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.AggregationFramework" -Dmongodb.uri="mongodb+srv://USERNAME:PASSWORD@cluster0-abcde.mongodb.net/test?w=majority"
```
