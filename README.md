Turf Booking System

Overview :

Turf Booking System is a Full Stack Web Application developed using Java, Spring Boot, MySQL, HTML, CSS, and JavaScript. The system allows users to register, log in, book turf slots, manage bookings, and view booking history. Administrators can monitor bookings through an admin dashboard and track booking statistics.


Feature :
  User Features ->

* User Registration
* User Login
* Role-Based Access (Admin/User)
* View Available Turf Slots
* Select and Book Turf Slots
* Prevent Double Booking for the Same Slot and Date
* Payment Status Selection (PAID / PENDING)
* View My Bookings
* View Booking History
* Cancel Booking
* Booking Status Tracking (CONFIRMED / CANCELLED)

  Admin Features ->

* Admin Login
* View All Bookings
* Dashboard Statistics

  * Total Bookings
  * Paid Bookings
  * Pending Bookings
* View Booking Details
* Monitor Booking Status

  System Features ->

* RESTful API Architecture
* Layered Architecture (Controller-Service-Repository)
* MySQL Database Integration
* JPA/Hibernate ORM
* Cross-Origin Support
* Responsive User Interface
* Exception Handling for Invalid Operations


Technology Stack :

  Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

  Frontend

* HTML5
* CSS3
* JavaScript

  Tools

* Eclipse IDE
* Git
* GitHub
* Postman



Project Structure :

src/main/java

├── controller

├── service

├── service/impl

├── repository

├── model

├── dto

└── util

src/main/resources/static

├── css

├── js

└── html pages



API Endpoints :

  1) User APIs

| Method | Endpoint            | Description   |
| ------ | ------------------- | ------------- |
| POST   | /api/users/register | Register User |
| POST   | /api/users/login    | Login User    |

  2) Booking APIs

| Method | Endpoint                    | Description          |
| ------ | --------------------------- | -------------------- |
| POST   | /api/bookings/create        | Create Booking       |
| GET    | /api/bookings/{id}          | Get Booking By ID    |
| GET    | /api/bookings               | Get All Bookings     |
| GET    | /api/bookings/date/{date}   | Get Bookings By Date |
| GET    | /api/bookings/user/{userId} | Get User Bookings    |
| PUT    | /api/bookings/cancel/{id}   | Cancel Booking       |

   3) Slot APIs

| Method | Endpoint   | Description         |
| ------ | ---------- | ------------------- |
| GET    | /api/slots | Get Available Slots |

  4) Payment APIs

| Method | Endpoint                         | Description     |
| ------ | -------------------------------- | --------------- |
| POST   | /api/payment/process/{bookingId} | Process Payment |



Business Rules :

* A slot cannot be booked twice for the same date.
* Users must be logged in before booking.
* Users can view their booking history.
* Users can cancel bookings.
* Cancelled bookings are tracked separately from active bookings.
* Payment status can be marked as PAID or PENDING.



Future Enhancements :

* Admin Slot Management
* Search and Filter Bookings
* JWT Authentication
* Email Notifications
* Revenue Dashboard
* Booking Reports Export


What I Learned :

Through this project, I gained hands-on experience in:

* Building Full Stack Web Applications using Java, Spring Boot, MySQL, HTML, CSS, and JavaScript.
* Designing and developing RESTful APIs.
* Implementing layered architecture (Controller, Service, Repository).
* Working with Spring Data JPA and Hibernate for database operations.
* Creating user authentication and role-based access functionality.
* Managing CRUD operations and business logic.
* Handling booking workflows and preventing double bookings.
* Integrating frontend and backend using Fetch API.
* Managing application state using Local Storage.
* Working with Git and GitHub for version control.
* Debugging backend and frontend issues.
* Building responsive and user-friendly interfaces.
* Testing APIs using Postman.
* Understanding real-world booking system workflows and database relationships.

GitHub: https://github.com/Saloni13
