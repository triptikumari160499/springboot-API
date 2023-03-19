package com.example.simpleviralgames.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.simpleviralgames.crud.respository.GameRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This represents Spring Boot application class for CRUD operations.
 * This class is responsible for enabling MongoDB repositories for database and
 * Swagger UI for API endPoint testing.
 */
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = GameRepository.class)
@EnableSwagger2

public class CrudApplication {

	/**
	 * Main method to start the Spring Boot application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
