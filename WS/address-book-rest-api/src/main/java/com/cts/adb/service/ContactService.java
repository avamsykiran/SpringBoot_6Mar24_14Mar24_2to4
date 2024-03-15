package com.cts.adb.service;

import java.util.List;

import com.cts.adb.entities.Contact;
import com.cts.adb.exceptions.ContactNotFoundException;

public interface ContactService {

	Contact add(Contact contact);
	
	Contact update(Contact contact) throws ContactNotFoundException;

	void deleteById(int contactId) throws ContactNotFoundException;

	Contact getById(int contactId) throws ContactNotFoundException;

	List<Contact> getAll();

	Contact getByMobile(String mmbielNumber) throws ContactNotFoundException;
}
