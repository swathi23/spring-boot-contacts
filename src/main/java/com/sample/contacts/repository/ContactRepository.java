package com.sample.contacts.repository;

import com.sample.contacts.models.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactRepository extends PagingAndSortingRepository<Contact, String> {
    Page<Contact> findByFirstNameIsLikeOrLastNameIsLike(Pageable pageable, String firstName, String lastName);
}
