Backend setup Instructions
To set up the backend of the Book Social Network project, follow these steps:

Clone the repository:
   git clone https://github.com/artur-kamalov/book-social-fullstack-app
Run the docker-compose file
  docker-compose up -d
Navigate to the book-social-network directory:
  cd book-social-network
Install dependencies (assuming Maven is installed):
  mvn clean install
Run the application but first replace the x.x.x with the current version from the pom.xml file
  java -jar target/book-network-api-x.x.x.jar
Access the API documentation using Swagger UI:
Open a web browser and go to `http://localhost:8088/swagger-ui/index.html.
