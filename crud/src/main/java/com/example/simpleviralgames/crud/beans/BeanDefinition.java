package com.example.simpleviralgames.crud.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * This class defines the Swagger configuration for the Spring Boot application.
 * It creates a Docket bean to configure the Swagger API documentation for the
 * application.
 * The Swagger API documentation is generated based on the REST APIs defined in
 * the application.
 */

@Configuration
public class BeanDefinition {

    /**
     * Creates a Docket bean to configure the Swagger API documentation for the
     * application.
     * 
     * @return A Docket object representing the Swagger API documentation
     *         configuration.
     */
    @Bean
    public Docket swaggerapi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Configures the metadata for the Swagger API documentation.
     * 
     * @return An API Info object representing the metadata for the Swagger API
     *         documentation.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Simple Viral Games")
                .description("REST APIs")
                .version("1.0.0")
                .build();
    }

}
