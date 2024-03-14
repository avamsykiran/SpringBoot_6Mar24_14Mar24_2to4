package com.cts.adb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.adb.entities.Contact;
import com.cts.adb.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactsApi {
	
	@Autowired
	private ContactService contactService;

	@GetMapping
	public ResponseEntity<List<Contact>> getAllAction(){
		//return new ResponseEntity<>(contactService.getAll(), HttpStatus.OK);
		return ResponseEntity.ok(contactService.getAll());
	}

	@GetMapping("/{cid:[1-9][0-9]{0,5}}")
	public ResponseEntity<Contact> getByIdAction(@PathVariable("cid") int contactId){
		Contact contact = contactService.getById(contactId);
		//return contact!=null ? new ResponseEntity<>(contact, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return contact!=null ?  ResponseEntity.ok(contact) :  ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{mno:[1-9][0-9]{9}}")
	public ResponseEntity<Contact> getByMobileAction(@PathVariable("mno") String mobileNumber){
		Contact contact = contactService.getByMobile(mobileNumber);
		//return contact!=null ? new ResponseEntity<>(contact, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return contact!=null ?  ResponseEntity.ok(contact) :  ResponseEntity.notFound().build();
	}

}
