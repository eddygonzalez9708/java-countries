package com.lambdaschool.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication {
    public static Countries countries;
    public static void main(String[] args) {
        countries = new Countries();
        SpringApplication.run(JavaCountriesApplication.class, args);
    }
}

