package com.andrewmcguiness.civroulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CivRouletteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CivRouletteApplication.class, args);
    }
}
