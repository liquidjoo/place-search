package com.github.liquidjoo.placesearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlaceSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlaceSearchApplication.class, args);
    }

}
