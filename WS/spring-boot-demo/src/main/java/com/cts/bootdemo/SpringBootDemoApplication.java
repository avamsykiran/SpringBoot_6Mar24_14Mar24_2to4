package com.cts.bootdemo;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	Scanner scan() {
		return new Scanner(System.in);
	}
	
	@Bean
	LocalDateTime rightNow() {
		return LocalDateTime.now();
	}
}
