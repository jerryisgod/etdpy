package com.etdpy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.etdpy.*"})
public class EtdpyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtdpyApplication.class, args);
	}

}
