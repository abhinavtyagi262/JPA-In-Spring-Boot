package com.abhinav;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Student Registration Microservice",
                version = "1.0",
                description = "APIs documentation for Student Registration Microservice"
        )
)
@SpringBootApplication
public class FrontController {

    public static void main(String[] args) {
        SpringApplication.run(FrontController.class, args);
    }

}
