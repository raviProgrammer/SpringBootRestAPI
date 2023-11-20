package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.ContactEntity;
import com.ravi.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

    @Override
    public ContactEntity saveContact(ContactEntity ContactEntity) {
        contactRepository.save(ContactEntity);
        return ContactEntity;
    }

    @Override
    public List<ContactEntity> fetchAllContacts() {
        List<ContactEntity> contactEntities = contactRepository.findAll();
        return contactEntities;
    }

    @Override
    public ContactEntity fetchContactById(Long id) {
    	Optional<ContactEntity> contact = contactRepository.findById(id);
    	if(contact.isPresent())
    		return contact.get();
    	else
    		return null;
    }

    @Override
    public String deleteContact(Long id) {
    	Optional<ContactEntity> contact = contactRepository.findById(id);
    	if(contact.isPresent()) {
    		contactRepository.deleteById(id);
            return id+" successfully deleted";
    	}
    	else {
    		return id+" not found";
    	}  
    }

    @Override
    public ContactEntity updateContact(Long id, ContactEntity contact) {
        ContactEntity contactEntity = contactRepository.findById(id).get();
        contactEntity.setFirstName(contact.getFirstName());
        contactEntity.setLastName(contact.getLastName());
        contactEntity.setEmailAddress(contact.getEmailAddress());
        contactEntity.setMobile(contact.getMobile());
        contactEntity.setOffice(contact.getOffice());
        contactRepository.save(contactEntity);
        return contact;
    }


}
