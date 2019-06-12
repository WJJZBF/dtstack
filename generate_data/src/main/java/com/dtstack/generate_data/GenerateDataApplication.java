package com.dtstack.generate_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class GenerateDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateDataApplication.class, args);
	}

}
