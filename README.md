# rabbitmq-exchange

This is a simple project to show to my students how they could implement Spring RabbitMQ in a context of Microservices.
This code is not perfect this is just a Proof of Concept in order to understand the mechanics.

## Run the apps
use docker to run rabbitMQ
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management

run RabbitmqApplication.class as java Application or Spring Boot application

## Try it
GET http://localhost:8080/created

GET http://localhost:8080/updated

GET http://localhost:8080/deleted


## Configure and run consumer 
Got to https://github.com/ScorprocS/rabbitmq-exchange-consumer
![image](https://user-images.githubusercontent.com/17098005/163706890-2321452d-7a6e-41e9-a2cc-b26ec88ce7b7.png)



