To set up the backend of the Book Social Network project, follow these steps:

1. Clone the repository:

```bash
   git clone  https://github.com/artur-kamalov/book-social-fullstack-app.git
```

2. Run the docker-compose file

```bash
  docker-compose up -d
```

3. Navigate to the book-social-network directory:

```bash
  cd book-network
```

4. Install dependencies (assuming Maven is installed):

```bash
  mvn clean install
```

4. Run the application

```bash
  java -jar target/book-network-api-x.x.x-SNAPSHOT.jar
```

5. Access the API documentation using Swagger UI:

Open a web browser and go to http://localhost:8088/api/v1/swagger-ui/index.html
