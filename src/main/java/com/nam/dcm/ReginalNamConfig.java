package com.nam.dcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReginalNamConfig {

	public static void main(String[] args) {

		SpringApplication.run(
				new Object[] { ReginalNamConfig.class }, args);
	}
}
//http://localhost:8080//namdcm-kafka/producer?message=test