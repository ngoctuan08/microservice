Microservice Sample
==================

This is a sample to show how Kafka can be used for the communication
between microservices.

The project creates Docker containers.

It uses three microservices:
- Order to create orders. This services sends messages to Kafka. It
  uses the `KafkaTemplate`.
- Shipment receives the orders and extract the
  information needed to ship the items.
- Invoicing receives the messages, too. It extracts all information to send
out an invoice. It uses `@KafkaListener` just like Shipment.

This is done using a topic order. It has five partitions. Shipment and
invoicing each have a separate consumer group. So multiple instances
of shipment and invoicing can be run. Each instance would get specific
events.

Technologies
------------

- Spring Boot
- Spring Kafka
- Apache httpd
- Kafka
- Zookeeper
- Postgres
- Docker Compose to link the containers.

Remarks on the Code
-------------------

The microservices are: 
- [order-service] to create the orders
- [shipping-service] for the shipping
- [invoice-service] for the invoices
