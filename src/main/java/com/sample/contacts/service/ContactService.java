package com.sample.contacts.service;

import com.sample.contacts.models.Contact;
import com.sample.contacts.models.ContactRequest;

public interface ContactService {
    void addContact(ContactRequest request);

    Contact getContactByEmail(String email);
}
