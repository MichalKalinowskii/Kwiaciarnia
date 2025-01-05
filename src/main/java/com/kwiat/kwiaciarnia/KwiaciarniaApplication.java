package com.kwiat.kwiaciarnia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "com.kwiat.kwiaciarnia.Repository")
public class KwiaciarniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KwiaciarniaApplication.class, args);
	}

}
