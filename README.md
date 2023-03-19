# springboot-API

This Spring Boot application provides a simple REST API for managing games using MongoDB as a database.

### Dependencies

* Spring Boot Starter Web: provides the necessary libraries for building a web application with Spring Boot
* Spring Boot Starter Data MongoDB: provides the necessary libraries for working with MongoDB
* Springfox Swagger2: provides automatic generation of API documentation

### Installation

Clone the repository: https://github.com/triptikumari160499/springboot-API.git

Open the project in your preferred IDE.
Update the application.properties file with your MongoDB connection details.
Run the application: mvn spring-boot:run

### API Documentation

To access the API documentation, go to https://springbootapi-simpleviralgames.up.railway.app/swagger-ui/index.html

### API Endpoints

* GET /api/games: retrieve all games
* GET /api/games/{id}: retrieve a specific game by its ID
* POST /api/games: create a new game
* PUT /api/games/{id}: update an existing game
* DELETE /api/games/{id}: delete a game by its ID

### Error Handling

When an error occurs, an appropriate HTTP status code is returned along with a message indicating the error.
