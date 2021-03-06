package com.walaszczyk.contactmanager.service;

import com.walaszczyk.contactmanager.domain.Contact;
import com.walaszczyk.contactmanager.repository.ContactsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private ContactsRepository contactsRepository;

    public ContactService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public List<Contact> getContactsByUserId(Long userId){
        return contactsRepository.findByUserid(userId);
//        return contactsRepository.findAll();
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

    public Contact updateContact(Contact newContact, Long id) {
        return contactsRepository.findById(id).map(contact -> {
            contact.setName(newContact.getName());
            contact.setSurname(newContact.getSurname());
            contact.setPhoneNumber(newContact.getPhoneNumber());
            return contactsRepository.save(contact);
        }).orElseGet(() -> {
            newContact.setId(id);
            return contactsRepository.save(newContact);
        });
    }

    public boolean deleteContact(Long id) {
        try {
            contactsRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
