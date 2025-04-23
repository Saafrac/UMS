// src/main/java/com/ums/UniversityManagementSystemApplication.java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.demo",
        "com.example.demo.mapper"
})
public class UniversityManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemApplication.class, args);
    }
}
