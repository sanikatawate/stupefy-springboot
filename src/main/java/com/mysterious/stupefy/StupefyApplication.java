package com.mysterious.stupefy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StupefyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StupefyApplication.class, args);
	}

}
