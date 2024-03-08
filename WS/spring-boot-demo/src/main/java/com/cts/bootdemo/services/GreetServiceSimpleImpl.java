package com.cts.bootdemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetServiceSimpleImpl implements GreetService {

	@Override
	public String greetUser(String userName) {
		String greeting = "Hello ";
		return greeting + userName;
	}

}
