package com.cts.adb.service;

import java.util.List;

import com.cts.adb.entities.Contact;

public interface ContactService {

	Contact add(Contact contact);
	void deleteById(int contactId);
	Contact getById(int contactId);
	List<Contact> getAll();
	
	default Contact getByMobile(String mmbielNumber) {
		return null;
	}
	
}
