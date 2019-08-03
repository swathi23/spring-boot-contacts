package com.sample.contacts.service;

import com.sample.contacts.models.Contact;
import com.sample.contacts.models.ContactNotFoundException;
import com.sample.contacts.models.ContactRequest;
import com.sample.contacts.models.DatabaseException;
import com.sample.contacts.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Contact getContactByEmail(String email) {
        Optional<Contact> contact = repository.findById(email);
        if(contact.isPresent()) {
            return contact.get();
        }
        throw new ContactNotFoundException("Couldn't fetch contact by email");
    }

    @Override
    public List<Contact> getContactByName(String name, int page, int size) {
        Page<Contact> contacts = repository.findByFirstNameIsLikeOrLastNameIsLike(PageRequest.of(page - 1, size), name, name);
        return contacts.getContent();
    }
}
