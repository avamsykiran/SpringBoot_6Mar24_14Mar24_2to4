package com.cts.springdemo;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.cts.springdemo.views.DemoView;

@Configuration
@ComponentScan("com.cts.springdemo")
@PropertySource("classpath:application.properties")
public class DemoApplication {
	
	public static void main(String a[]) {
		
		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(DemoApplication.class);
		
		DemoView view = (DemoView) container.getBean("demoView");
		view.run();
		
		container.close();
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