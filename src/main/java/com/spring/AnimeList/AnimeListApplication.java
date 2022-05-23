package com.spring.AnimeList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AnimeListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeListApplication.class, args);
	}

}
