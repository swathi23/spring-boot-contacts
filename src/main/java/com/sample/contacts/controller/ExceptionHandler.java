package com.sample.contacts.controller;

import com.sample.contacts.models.ContactNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Log4j2
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity sendNotFoundResponse(ContactNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
