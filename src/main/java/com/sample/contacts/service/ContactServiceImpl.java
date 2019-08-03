package com.sample.contacts.service;

import com.sample.contacts.models.Contact;
import com.sample.contacts.models.ContactRequest;
import com.sample.contacts.models.DatabaseException;
import com.sample.contacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private ContactRepository repository;

    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addContact(ContactRequest request) {
        Contact contact = repository.save(new Contact(request.getEmail(), request.getFirstName(), request.getLastName(), request.getPhone()));
        if(contact == null) {
            throw new DatabaseException("Error saving contact");
        }
    }
}
