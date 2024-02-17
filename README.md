# Spring Maven Docker Base App

- This is a basic template for a Spring Boot application set up with Maven and Docker.
- It provides a starting point for building and running Spring Boot applications in a Docker containerized environment.


## Getting Started

To get started with this project, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/radekcz/spring-maven-docker-base.git

2. **Build the application using Maven:**
   ```bash
   cd spring-maven-docker-base
   mvn clean package

3. **Build the Docker image:**
   ```bash
   docker build -t spring-maven-docker-base-app .

4. **Run the Docker image:**
   ```bash
   docker run -p 8080:8080 spring-maven-docker-base-app

This will start the Spring Boot application inside a Docker container and expose it on port 8080.

5. **Access the application:**

Open your web browser and navigate to http://localhost:8080 to access the running Spring Boot application.
