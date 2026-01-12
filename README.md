# Birth App

Spring Boot API for birth declaration management.

## Overview

Birth App is a RESTful backend service built with Spring Boot.  
It provides APIs to manage birth declarations and related data, and is designed to be configurable via environment
variables for different environments (development, testing, production).

---

## Tech Stack

- Java 21+
- Spring Boot
- Spring Web
- Spring Data JPA
- Database: PostgreSQL (configurable)
- Maven

---

## Database Configuration

The application uses environment variables defined in (`.env` file) for database configuration.

### Required Environment Variables

```env
DB_NAME=
DB_USERNAME=
DB_PASSWORD=
```

## LOG

Define the log level inside the `.env`. The default is `warn`

```env
LOG_LEVEL=
