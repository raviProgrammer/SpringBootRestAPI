package com.ravi.service;

import java.util.List;
import com.ravi.entity.ContactEntity;

public interface ContactService {
    ContactEntity saveContact(ContactEntity contactEntity);
    List<ContactEntity> fetchAllContacts();
    ContactEntity fetchContactById(Long id);
    String deleteContact(Long id);
    ContactEntity updateContact(Long id, ContactEntity contactEntity);
}
