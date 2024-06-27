package com.example.planIt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DemozzzzApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemozzzzApplication.class, args);
	}

}
