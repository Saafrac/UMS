# University Management System (UMS)

A RESTful Spring Boot application for managing a university system. Supports authentication, CRUD operations, and role-based authorization.

---

## Project Structure Overview

- `config/`: Configurations
- `controller/`: Handles API requests
- `dto/`:  Data Transfer Objects
- `entity/`: Entities like Student, Course and etc.
- `exception/`: Error handling
- `factory/`: Create entities from DTOs
- `mapper/`: MapStruct interfaces
- `repository/`: Data access layer (Spring Data JPA)
- `security/`: JWT and filters
- `service/`: Business logic layer
- `specification/`: Dinamic SQL query builder for filters(JPA criteria API)
- `strategy`: Course sorting stratagy pattern

---

## Example API Endpoints

- `POST /auth/register` – Register new user
- `POST /auth/login` – Login and receive JWT
- `POST /students` – Add student (ADMIN)
- `GET /courses` – View all courses (ALL)
- `POST /enrollments` – Enroll student (ADMIN, TEACHER)

API Documentation (Swagger)
This project includes interactive API documentation via Swagger UI, powered by springdoc-openapi.

Swagger UI:
```http://localhost:8080/swagger-ui/index.html```
OpenAPI JSON spec:
```http://localhost:8080/v3/api-docs```

---

## Technologies Used

- Java 21
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL
- Flyway
- MapStruct
- Lombok
- Swagger

---

## Build and Run Commands

```bash

```

## Contacts

- `Telegram:` *@saafrac*
- `Email:` *suhansun13@gmail.com*
- `Number:` *+7 777 101 0206*
