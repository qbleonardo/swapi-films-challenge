package com.swapi.challengefilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ChallengeFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeFilmesApplication.class, args);
	}

}
