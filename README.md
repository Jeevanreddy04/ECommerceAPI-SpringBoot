Title:

ECommerceAPI-SpringBoot – A RESTful backend API for E-Commerce applications built with Spring Boot and PostgreSQL.

Description:

This project is a Spring Boot-based backend for an E-Commerce platform. It provides REST APIs to manage different roles and core functionalities:

1. Admin

Create and manage admin users.

Add, update, or delete admin addresses.

Add and update products.

View pending orders.

Assign carriers to deliver orders.

2. Carrier

Register and manage carrier accounts.

View assigned orders and delivery addresses.

Update order delivery status.

3. Customer

Register and manage customer accounts.

Browse products.

Place and track orders.

Manage shipping addresses.

The APIs follow a Controller-Service-Repository architecture, ensuring clean separation of concerns and scalability. Responses are wrapped in a custom ResponseStructure for consistency.

💡 Technologies Used:

Spring Boot

Java

JPA / Hibernate

PostgreSQL

RESTful APIs

Jakarta Validation
