package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.entity.ContactEntity;
import com.ravi.service.ContactService;

@SuppressWarnings({"all"})
@CrossOrigin(origins = {"http://localhost:9417"})
@RestController
@RequestMapping("cms/api/v1")
public class ContactController {
	
	@Autowired
    private ContactService contactService;

    @PostMapping("/saveContact")
    public ContactEntity saveContact(@RequestBody ContactEntity contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping("/fetchContacts")
    public List<ContactEntity> fetchAllContacts() {
        return contactService.fetchAllContacts();
    }

    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<ContactEntity> fetchContactById(@PathVariable("id") Long id) {
    	ContactEntity contact =  contactService.fetchContactById(id);
        return new ResponseEntity<ContactEntity>(contact, HttpStatus.OK);
    }

    @DeleteMapping("/deleteContactBy/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long id) {
        String deleted = contactService.deleteContact(id);
        return new ResponseEntity<String>(deleted, HttpStatus.OK);
    }

    @PutMapping("/updateContact/{id}")
    public ResponseEntity<ContactEntity> updateContact(@PathVariable("id") Long id, @RequestBody ContactEntity contact){
        contact = contactService.updateContact(id, contact);
        return new ResponseEntity<ContactEntity>(contact, HttpStatus.OK);
    }
}