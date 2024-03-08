package com.cts.bootdemo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceTimedImpl implements GreetService {

	@Autowired
	private LocalDateTime now;
	
	@Override
	public String greetUser(String userName) {
		String greeting = "";
		
		int h = now.getHour();
		
		if(h>=4 && h<=11) greeting = "Good Morning ";
		else if(h>11 && h<=16) greeting = "Good Noon ";
		else greeting= "Good Evening ";
		
		return greeting + userName;
	}

}
