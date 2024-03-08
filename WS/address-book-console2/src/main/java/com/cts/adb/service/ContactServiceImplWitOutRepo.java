package com.cts.adb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.adb.entities.Contact;

@Service
public class ContactServiceImplWitOutRepo implements ContactService {

	private List<Contact> contacts;
	private int nextId;
	
	public ContactServiceImplWitOutRepo() {
		contacts = new ArrayList<>();
		nextId=1;
	}
	
	@Override
	public Contact add(Contact contact) {
		if(contact!=null) {
			contact.setContactId(nextId++);
			contacts.add(contact);
		}
		return contact;
	}

	@Override
	public void deleteById(int contactId) {
		Contact contact = contacts.stream().filter(c -> c.getContactId()==contactId).findFirst().orElse(null);
		if(contact!=null) {
			contacts.remove(contact);
		}
	}

	@Override
	public Contact getById(int contactId) {
		return contacts.stream().filter(c -> c.getContactId()==contactId).findFirst().orElse(null);
	}

	@Override
	public List<Contact> getAll() {
		return contacts;
	}

}
