package com.example.crypto_automatioon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CryptoAutomatioonApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CryptoAutomatioonApplication.class, args);
		SpringApplication.exit(run);
	}

}
