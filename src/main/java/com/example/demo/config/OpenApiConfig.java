package com.example.demo.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI umsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("University Management System API")
                        .description("CRUD and authentication for Admin, Teacher, Student roles")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Dulat Ali")
                                .email("suhansun13@gmail.com")
                        )
                )
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}

