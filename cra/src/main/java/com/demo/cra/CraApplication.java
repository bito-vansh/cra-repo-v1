package com.demo.cra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CraApplication.class, args);
	}

}
