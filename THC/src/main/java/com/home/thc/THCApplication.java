package com.home.thc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.home"})
public class THCApplication {

    public static void main(String[] args) {
        SpringApplication.run(THCApplication.class, args);
    }

}
