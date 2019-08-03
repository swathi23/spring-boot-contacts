package com.sample.contacts.controller;

import com.sample.contacts.models.Contact;
import com.sample.contacts.models.ContactRequest;
import com.sample.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/contacts/v1")
public class RestController {

    @Autowired
    private ContactService contactService;

    @PostMapping()
    public ResponseEntity addContact(@RequestBody ContactRequest request) throws IOException {
        contactService.addContact(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity getContactByEmail(@PathVariable(name = "email") String email) {
        Contact contact = contactService.getContactByEmail(email);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getContactByName(@PathVariable(name = "name") String name,
                                           @RequestParam(name = "page", defaultValue = "1") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size) {
        List<Contact> contact = contactService.getContactByName(name, page, size);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity deleteByEmail(@PathVariable(name = "email") String email) {
        contactService.deleteContact(email);
        return new ResponseEntity(HttpStatus.OK);
    }
}
