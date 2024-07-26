package com.etdpy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import jakarta.persistence.Entity;

@SpringBootApplication
public class EtdpyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtdpyApplication.class, args);
    }

}
