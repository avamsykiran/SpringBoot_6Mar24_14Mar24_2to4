package com.cts.bootdemo.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootDemoRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Worl! This si Spring Boot 2.7 - I am Runner 3");
	}

}