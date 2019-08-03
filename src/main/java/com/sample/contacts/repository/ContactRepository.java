package com.sample.contacts.repository;

import com.sample.contacts.models.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact, String> {
}
