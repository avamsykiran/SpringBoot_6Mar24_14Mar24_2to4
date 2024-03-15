package com.cts.adb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.adb.entities.Contact;
import com.cts.adb.exceptions.ContactNotFoundException;
import com.cts.adb.repos.ContactRepo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public Contact add(Contact contact) {
		return contactRepo.save(contact);
	}

	@Override
	public void deleteById(int contactId) throws ContactNotFoundException{
		if(!contactRepo.existsById(contactId)) {
			throw new ContactNotFoundException("Contact#"+contactId+" doesn't exist to delete!");
		}
		contactRepo.deleteById(contactId);
	}

	@Override
	public Contact getById(int contactId) throws ContactNotFoundException {
		Contact contact = contactRepo.findById(contactId).orElse(null);
		if(contact==null) {
			throw new ContactNotFoundException("Contact#"+contactId+" doesn't exist!");
		}
		return contact;
	}

	@Override
	public List<Contact> getAll() {
		return contactRepo.findAll();
	}
	
	@Override
	public Contact getByMobile(String mmbielNumber) throws ContactNotFoundException {
		Contact contact = contactRepo.findByMobileNumber(mmbielNumber).orElse(null);
		if(contact==null) {
			throw new ContactNotFoundException("Contact with mobile number"+ mmbielNumber +" doesnt exist!");
		}
		return contact;
	}

	@Override
	public Contact update(Contact contact) throws ContactNotFoundException {
		if(!contactRepo.existsById(contact.getContactId())) {
			throw new ContactNotFoundException("Contact#"+contact.getContactId()+" doesnt exist to update!");
		}
		return contactRepo.save(contact);
	}
}

