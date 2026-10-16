# Student Management System

Ready-to-run Spring Boot 4.1.1 project using Java 21 and an embedded H2 database.

## Run
```bash
cd student-management
./mvnw spring-boot:run
```

Then open:
http://localhost:8080/

## Features
- Add student
- View students
- Edit student
- Delete student
- JPA persistence
- Validation
- Embedded H2 database (no MySQL installation required)
- H2 console at http://localhost:8080/h2-console

H2 JDBC URL:
`jdbc:h2:file:./data/studentdb`
User: `sa`
Password: leave blank
