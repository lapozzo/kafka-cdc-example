# Introduction

Simple Change Data Capture example with Debezium, PostgreSQL, Springboot consumer e producer sending back the data for another Kafka Topic.

Flow: 

[PostgreSQL] <- [Debezium] -> [Kafka] <- [Springboot Consumer] -> [Springboot Producer] -> [Kafka]


## Requirements
* Docker + Docker Compose

## Start Environment
* Kafka
* Zookeeper
* Debezium
* PostgreSQL

```sh
docker-compose up -d
```

### Connect PostgreSQL
```sh
docker-compose exec postgres bash
psql -h localhost -U postgres
```

### Create Database
```sql
CREATE DATABASE dummy_database;
```

### Create Database
```sql
CREATE DATABASE dummy_database;
```

### Create Table
```sql
\c dummy_database;
CREATE TABLE dummy_table(id serial PRIMARY KEY, name varchar(20), address text, age int);
```

### Insert some rows
```sql
 insert into dummy_table(name, address, age) values('XYZ','location-A',25);
 insert into dummy_table(name, address, age) values('ABC','location-B',35);
 insert into dummy_table(name, address, age) values('DEF','location-C',40);
 insert into dummy_table(name, address, age) values('PQR','location-D',54);
```


### Run Debezium connector
```sh
curl -X POST -H "Content-Type: application/json" --data @./debezium-cdc-connector.json localhost:8083/connectors
```