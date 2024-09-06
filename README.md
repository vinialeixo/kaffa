
# Kaffa Project

This is the repository for the Kaffa project, a Spring Boot application with an H2 database and Swagger integration to test API requests.

## Cloning the Repository

To clone the project to your local machine, run the following command in the terminal:

```bash
git clone https://github.com/vinialeixo/kaffa
```

Replace `your-username` and `your-repository` with the correct path to your GitHub repository.

## Technologies Used

- **Spring Boot**: A Java framework for building robust web applications.
- **H2 Database**: An in-memory database configured for this project.
- **Swagger**: A tool for API documentation and testing.

## Database Configuration

The project uses the H2 database, which is automatically created in memory when running the application. No manual database configuration is required.


## Testing the API with Swagger

The API is documented with Swagger, allowing you to test the requests directly from the browser.

After starting the application, access Swagger at the following link:

```
http://localhost:8080/swagger-ui.html


```
![Captura de tela 2024-09-05 222811](https://github.com/user-attachments/assets/3d6c91ce-1909-406a-ae0d-ffbd10cdf94d)

Here, you can view and interactively test all API routes.

## Running the Project

After cloning the repository, you can run the application with the following command:

```bash
./mvnw spring-boot:run
```

This will start the Spring Boot application, and both Swagger and the H2 database will be automatically available.
