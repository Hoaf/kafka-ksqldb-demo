# Kafka with Spring Boot and KSQL Demo

This project demonstrates the integration of Kafka with a Spring Boot application. It includes examples of producing and consuming messages using Kafka, as well as utilizing KSQL for stream processing.

---

## Features
- **Kafka Producer and Consumer**: Basic setup for sending and receiving messages.
- **KSQL Integration**: Process streams of data using KSQL for querying and transforming Kafka topics.
- **Dockerized Environment**: All required Kafka services, including Zookeeper, Kafka Broker, and KSQL Server, are provided through Docker Compose.

---

## Prerequisites

Before running the project, ensure you have the following installed:

- [Docker](https://www.docker.com/products/docker-desktop) (version 20.x or higher)
- [Docker Compose](https://docs.docker.com/compose/install/) (version 1.29 or higher)
- [Java 17](https://adoptopenjdk.net/)
- [Maven 3.8+](https://maven.apache.org/download.cgi)

---

## Setup

### Step 1: Start Kafka and KSQL Services

1. Navigate to the directory containing the `docker-compose.yml` file.

2. Run the following command to start the services:
   ```bash
   docker-compose up -d
   
3. Build the project using Maven:
   mvn clean install
4. Run the Spring Boot application:
   mvn spring-boot:run
   
### Using KSQL (Example)
1. docker exec -it ksql-server ksql http://localhost:8088
2. Create a KSQL stream from the orders-topic:
CREATE STREAM orders_stream (
    order_id INT,
    customer_name STRING,
    amount DOUBLE,
    status STRING
) WITH (
    KAFKA_TOPIC='orders-topic',
    VALUE_FORMAT='JSON'
);
3. SHOW STREAMS;
4. SELECT * FROM orders_stream EMIT CHANGES;