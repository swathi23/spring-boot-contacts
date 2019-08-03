package com.sample.contacts.service;

import com.sample.contacts.models.Contact;
import com.sample.contacts.models.ContactRequest;

import java.util.List;

public interface ContactService {
    void addContact(ContactRequest request);

    Contact getContactByEmail(String email);

    List<Contact> getContactByName(String name, int page, int size);

    void deleteContact(String email);
}
