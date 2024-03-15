package com.cts.adb.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.adb.entities.Contact;
import com.cts.adb.exceptions.ContactNotFoundException;
import com.cts.adb.exceptions.InvalidContactDetalsException;
import com.cts.adb.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactsApi {

	@Autowired
	private ContactService contactService;

	@GetMapping
	public ResponseEntity<List<Contact>> getAllAction() {
		// return new ResponseEntity<>(contactService.getAll(), HttpStatus.OK);
		return ResponseEntity.ok(contactService.getAll());
	}

	@GetMapping("/{cid:[1-9][0-9]{0,5}}")
	public ResponseEntity<Contact> getByIdAction(@PathVariable("cid") int contactId) throws ContactNotFoundException {
		return ResponseEntity.ok(contactService.getById(contactId));
	}

	@GetMapping("/{mno:[1-9][0-9]{9}}")
	public ResponseEntity<Contact> getByMobileAction(@PathVariable("mno") String mobileNumber)
			throws ContactNotFoundException {
		return ResponseEntity.ok(contactService.getByMobile(mobileNumber));
	}

	@PostMapping
	public ResponseEntity<Contact> addAction(@RequestBody @Valid Contact contact, BindingResult bindingResults)
			throws InvalidContactDetalsException {
		if (bindingResults.hasErrors()) {
			throw new InvalidContactDetalsException(bindingResults.getAllErrors().stream()
					.map(ObjectError::getDefaultMessage).reduce("", (m1, m2) -> m1 + "," + m2).substring(1));
		}
		return new ResponseEntity<>(contactService.add(contact), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Contact> updaeAction(@RequestBody @Valid Contact contact, BindingResult bindingResults)
			throws InvalidContactDetalsException, ContactNotFoundException {
		if (bindingResults.hasErrors()) {
			throw new InvalidContactDetalsException(bindingResults.getAllErrors().stream()
					.map(ObjectError::getDefaultMessage).reduce("", (m1, m2) -> m1 + "," + m2).substring(1));
		}

		return new ResponseEntity<>(contactService.update(contact), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{cid}")
	public ResponseEntity<Void> deleteByIdAction(@PathVariable("cid") int contactId) throws ContactNotFoundException {
		contactService.deleteById(contactId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
