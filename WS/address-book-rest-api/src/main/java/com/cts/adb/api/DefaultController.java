package com.cts.adb.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"","/"})
public class DefaultController {

	@GetMapping
	public String home() {
		return "This is a demo rest-api for contacts CRUD operations. '/contacts' is the end point";
	}
}
