package com.walaszczyk.contactmanager.repository;

import com.walaszczyk.contactmanager.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends CrudRepository<Contact, Long> {
    List<Contact> findAll();
    List<Contact> findByUserid(Long userid);

}
