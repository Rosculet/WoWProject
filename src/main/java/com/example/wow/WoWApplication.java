package com.example.wow;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WoWApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(WoWApplication.class, args);

        }
    }


