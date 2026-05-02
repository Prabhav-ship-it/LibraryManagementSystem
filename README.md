# Library Management System

A Spring Boot application with JPA, H2 Database, and JSP views.

## Features
- **Entities**: Author and Book (One-to-Many).
- **CRUD Operations**: List, Add, and Update books.
- **Custom Query**: Inner join between Book and Author using JPQL.
- **Data Initialization**: Automatically populates 10 rows on startup.
- **Testing**: Unit tests for the Service layer.

## How to Run
1. Ensure you have Java 17 and Maven installed.
2. Run the application:
   ```bash
   mvn spring-boot:run
   ```
3. Access the application:
   - Web App: [http://localhost:8080/](http://localhost:8080/)
   - H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
     - JDBC URL: `jdbc:h2:mem:librarydb`
     - Username: `sa`
     - Password: (empty)

## Testing
Run the tests using:
```bash
mvn test
```
