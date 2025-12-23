# PM API — Spring Boot Project Management Backend

A production-ready backend API built with **Spring Boot**, demonstrating real-world architecture, security, and best practices for SaaS-style applications.

This project was designed as a **portfolio flagship** to showcase backend engineering skills relevant for freelance and commercial projects.

---

## 🚀 Features

- User registration & login
- JWT-based authentication (stateless)
- Role-based access control
- Secure password hashing (BCrypt)
- Global exception handling
- H2 database for development
- Swagger / OpenAPI documentation
- Clean layered architecture
- Basic integration test
- Docker-ready

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3**
- Spring Security
- Spring Data JPA (Hibernate)
- JWT (jjwt)
- H2 Database
- Maven
- Swagger (springdoc-openapi)
- JUnit 5 + MockMvc
- Docker

---

## 📂 Project Structure

```

src/main/java/io/github/alisa_salimianova/pmapi
├── config          # Spring & security configuration
├── controller      # REST controllers
├── dto             # Request / response DTOs
├── entity          # JPA entities
├── exception       # Global error handling
├── repository      # Data access layer
├── security        # JWT & security logic
├── service         # Business logic
│   └── impl
└── Application.java

```

---

## 🔐 Authentication Flow

1. **Register user**
```

POST /api/v1/auth/register

```

2. **Login**
```

POST /api/v1/auth/login

```

3. Receive **JWT token**
4. Pass token in headers:
```

Authorization: Bearer <token>

```

5. Access protected endpoints

---

## 📘 Swagger UI

After starting the application, open:

```

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

````

You can:
- Explore all endpoints
- Test requests directly in browser
- View request/response models

---

## 🧪 Tests

The project includes a basic integration test to verify application startup and public endpoint access.

Tests use:
- Spring Boot Test
- MockMvc
- JUnit 5

Run tests:

```bash
mvn test
````

---

## 🗄 Database

* **H2 in-memory database** (dev profile)
* Automatically creates schema
* H2 Console available at:

```
http://localhost:8080/h2-console
```

JDBC URL:

```
jdbc:h2:mem:testdb
```

---

## ⚙️ Configuration

Main configuration files:

* `application.yml`
* `application-dev.yml`

JWT settings:

```yaml
jwt:
  secret: change-me
  expiration-ms: 3600000
```

---

## 🐳 Docker

Build image:

```bash
docker build -t pm-api .
```

Run container:

```bash
docker run -p 8080:8080 pm-api
```

---

## 🎯 Why This Project?

This project demonstrates:

* Real authentication & security (not mock logic)
* Clean separation of concerns
* Production-oriented configuration
* Debuggable, testable architecture
* Readable, maintainable code

It reflects how I approach **commercial backend development**, not tutorial code.

---

## 👩‍💻 Author

**Alisa Salimianova**
Java Backend Developer

GitHub: [https://github.com/Alisa-Salimianova](https://github.com/Alisa-Salimianova)

---

## 📌 Notes

This project is intentionally focused on backend quality rather than feature quantity.
It can be easily extended with:

* Projects & tasks domain
* PostgreSQL
* Flyway migrations
* Role management
* CI/CD pipelines

---
