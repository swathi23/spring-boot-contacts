package com.sample.contacts.controller;

import com.sample.contacts.models.ContactRequest;
import com.sample.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
}
