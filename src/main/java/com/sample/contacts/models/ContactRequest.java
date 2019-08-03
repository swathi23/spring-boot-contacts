package com.sample.contacts.models;

import lombok.Data;

@Data
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
