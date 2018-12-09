package com.walaszczyk.contactmanager.service;

import com.walaszczyk.contactmanager.domain.Contact;
import com.walaszczyk.contactmanager.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private ContactsRepository contactsRepository;

    public ContactService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public List<Contact> getAllContacts(){
        return contactsRepository.findAll();
    }

    public Optional<Contact> getContact(Long id){
        return contactsRepository.findById(id);
    }

    public Contact addContact(Contact contact) {
        return contactsRepository.save(contact);
    }
}
