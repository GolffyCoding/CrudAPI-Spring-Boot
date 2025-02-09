# CRUD API with Spring Boot

Welcome to the **CRUD API** built using **Spring Boot**! This application provides basic **Create**, **Read**, **Update**, and **Delete** operations for managing **Users** and **Products**. It also implements **JWT Authentication** for secure access.

## Features

- **User Management**: Register and login users with secure password storage.
- **Product Management**: Create, update, delete, and fetch product information.
- **JWT Authentication**: Secure API access using JSON Web Tokens (JWT).

## Prerequisites

Before running the application, make sure you have the following installed:

- [JDK 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html) (optional for building the app)
- [MySQL](https://dev.mysql.com/downloads/installer/) or any other compatible database
- [Postman](https://www.postman.com/) (for testing the API)

## Setup

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/GolffyCoding/CrudAPI-Spring-Boot.git
    cd crud-api
    ```

2. **Configure Database**:

    Update your `application.properties` or `application.yml` with the database credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. **Add JWT Secret and Expiration**:

    Add your **JWT Secret** and **JWT Expiration Time** in `application.properties`:

    ```properties
    jwt.secret=your_jwt_secret
    jwt.expiration=3600000 # 1 hour in milliseconds
    ```

4. **Build the Application**:

    You can build the application using **Maven**:

    ```bash
    mvn clean install
    ```

    Or directly run the application from your IDE.

5. **Run the Application**:

    Run the application using:

    ```bash
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080` by default.

## API Endpoints

### Authentication

- **POST** `/api/auth/register` – Register a new user
  - Body:
    ```json
    {
      "username": "john_doe",
      "email": "john.doe@example.com",
      "password": "password123"
    }
    ```

- **POST** `/api/auth/login` – Login and get a JWT token
  - Body:
    ```json
    {
      "username": "john_doe",
      "password": "password123"
    }
    ```

### Users

- **GET** `/api/users` – Get all users (requires JWT token)
- **GET** `/api/users/{id}` – Get user by ID (requires JWT token)
- **PUT** `/api/users/{id}` – Update user by ID (requires JWT token)
  - Body:
    ```json
    {
      "username": "new_username",
      "email": "new.email@example.com",
      "password": "newpassword123"
    }
    ```

- **DELETE** `/api/users/{id}` – Delete user by ID (requires JWT token)

### Products

- **GET** `/api/products` – Get all products (no JWT required)
- **GET** `/api/products/{id}` – Get product by ID (no JWT required)
- **POST** `/api/products` – Create a new product (requires JWT token)
  - Body:
    ```json
    {
      "name": "Product Name",
      "description": "Product Description",
      "price": 99.99
    }
    ```

- **PUT** `/api/products/{id}` – Update product by ID (requires JWT token)
  - Body:
    ```json
    {
      "name": "Updated Product Name",
      "description": "Updated Product Description",
      "price": 129.99
    }
    ```

- **DELETE** `/api/products/{id}` – Delete product by ID (requires JWT token)

## Testing the API with Postman

1. **Get JWT Token**:
   - Send a `POST` request to `/api/auth/login` with valid user credentials to get a JWT token.
   
2. **Use JWT Token**:
   - In your subsequent requests (for users and products), add the token to the **Authorization** header:
     ```
     Authorization: Bearer <your_jwt_token>
     ```

## Running H2 Database Console

If you're using H2 for testing, you can access the H2 console at:

