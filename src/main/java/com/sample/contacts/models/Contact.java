package com.sample.contacts.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Table(name = "contacts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {

    @Id
    @Column(name = "email", updatable = false, nullable = false)
    String email;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "phone")
    String phone;
}
