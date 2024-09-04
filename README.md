# Spring Boot MVC Security Demo 

From the Udemy Course from Chad Derby : Spring Boot 3, Spring 6 & Hibernate for Beginners

This project is a Spring Boot application designed to demonstrate the integration of Spring Security for authentication and authorization processes. It showcases various security configurations using Thymeleaf as the template engine for rendering views.

## Project Structure

The project is organized into several Java packages and resources:

- `com.luve2code.springboot.demosecurity` - Contains the main application and configuration classes.
- `com.luve2code.springboot.demosecurity.controller` - Contains the controllers for handling user requests.
- `resources/templates` - Contains Thymeleaf HTML templates for the UI.

### Controllers

There are two main controllers in this application:
- `DemoController` - Manages the routes for the home, leaders, and systems pages.
- `LoginController` - Manages authentication views and the access-denied page.

### Security

The application uses Spring Security for managing user authentication and authorization based on roles. It demonstrates handling of login and logout functionalities and restricts access based on user roles.

## Setup

### Requirements

- Java 17
- Maven
- MySQL

### Running the Application

1. **Database Setup**
   - Ensure MySQL is running on your local machine.
   - Create a database named `employee_directory` and import the initial setup SQL scripts from the `sql-scripts` directory.

2. **Build and Run**
   - Navigate to the root directory of the project via command line.
   - Execute the following Maven command to run the application:
     ```
     mvn spring-boot:run
     ```

3. **Access the Application**
   - Open a web browser and navigate to `http://localhost:8080` to access the application.
   - Use the following credentials to log in:
     - Username: `mary` or `susan` or `john`
     - Password: `fun123`

## Features

- **User Authentication**: Custom login and logout functionalities.
- **Role-Based Access Control**: Different views and functionalities based on user roles (`EMPLOYEE`, `MANAGER`, `ADMIN`).
- **Thymeleaf Integration**: Use of Thymeleaf templates for rendering HTML content dynamically based on the security context.

## Contributors

- [UDEMY Course](https://www.udemy.com/course/spring-hibernate-tutorial/?couponCode=SEPTSTACK24B)


