ECommerceAPI-SpringBoot – Technical Documentation
Overview

A production-style E-Commerce backend API built with Spring Boot and PostgreSQL.
This backend provides APIs to manage Admins, Carriers, Customers, Products, and Orders.

The application follows a Controller → Service → Repository architecture, ensuring clean separation of concerns and scalability.

Persistence: PostgreSQL

This application uses PostgreSQL as its primary relational database, suitable for production-grade applications.

Database Setup

Install PostgreSQL and create a database (e.g., ecommerce_db).

Run the provided schema SQL to create the required tables:

admins, customers, carriers, products, orders, addresses


Configure database in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update

Core Modules
Admin

Create, update, and manage admin users

Add, update, or delete admin addresses

Add and update products

View pending orders

Assign carriers to orders

Carrier

Register and manage carrier accounts

View assigned orders and delivery addresses

Update order delivery status

Customer

Register and manage customer accounts

Browse and search products

Place and track orders

Manage shipping addresses

# API Endpoints

| Module   | Method | Endpoint                                                | Description                  |
|----------|--------|--------------------------------------------------------|------------------------------|
| Admin    | POST   | /admin/save                                            | Create new admin             |
| Admin    | PATCH  | /admin/addaddress/{mob}                                | Add addresses to admin       |
| Admin    | GET    | /admin/getadmin/{mob}                                  | Get admin by mobile number   |
| Admin    | DELETE | /admin/deleteadd/{adminId}/address/{addressId}        | Delete admin address         |
| Carrier  | POST   | /admin/savecarrier                                     | Add new carrier              |
| Carrier  | GET    | /admin/seeallcarriers                                  | Get all carriers             |
| Carrier  | GET    | /admin/findcarrier/{mob}                               | Get carrier by mobile number |
| Carrier  | DELETE | /admin/deletecarrier/{mob}                             | Delete carrier               |
| Products | POST   | /admin/addproduct                                      | Add new product              |
| Products | GET    | /admin/getproducts                                     | Get all products             |
| Products | PATCH  | /admin/updateproduct/{id}/{status}                     | Update product status        |
| Orders   | GET    | /admin/seependingorders                                | Get pending orders           |
| Orders   | PATCH  | /admin/updatecarrier/assigncarrier/{ordid}/{carriermobno}/{addid} | Assign carrier to order |


Controller-Service-Repository Architecture – clean separation of API, business logic, and DB operations

Validation – input validated via @Valid and Jakarta Validation

Custom Response – all responses are wrapped in ResponseStructure for consistency

Role Management – separate APIs for Admin, Carrier, and Customer

Technologies Used

Spring Boot

Java

PostgreSQL

JPA / Hibernate

RESTful APIs

Jakarta Validation
