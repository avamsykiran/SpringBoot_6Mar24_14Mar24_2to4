package com.cts.springdemo.views;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.springdemo.services.GreetService;

@Component
public class DemoView {
	
	@Value("${app.name:UnknownApplication}")
	private String appName;

	@Autowired
	private GreetService greetService1;
	
	@Autowired
	@Qualifier("greetServiceTimedImpl")
	private GreetService greetService2;
	
	@Autowired
	@Qualifier("greetServiceSimpleImpl")
	private GreetService greetService3;
	
	@Autowired
	private Scanner scan;
	
	public void run() {
		System.out.println(appName);
		System.out.println("----------------------------------------------------------");
		
		System.out.println("User Name? ");
		String userName = scan.nextLine();
		
		System.out.println(greetService1.greetUser(userName));
		System.out.println(greetService2.greetUser(userName));
		System.out.println(greetService3.greetUser(userName));
	}
}