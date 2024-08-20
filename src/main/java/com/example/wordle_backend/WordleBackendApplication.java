package com.example.wordle_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class WordleBackendApplication{

    public static void main(String[] args) {
        SpringApplication.run(WordleBackendApplication.class, args);
    }

}
