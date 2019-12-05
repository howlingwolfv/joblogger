package com.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobLoggerApplication {

    public static void main(String[] args) {
        System.out.println("Begin");
        SpringApplication.run(JobLoggerApplication.class, args);
        System.out.println("End");
    }

}
