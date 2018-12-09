package com.walaszczyk.contactmanager.controller;

import com.walaszczyk.contactmanager.domain.Contact;
import com.walaszczyk.contactmanager.exceptions.ContactNotFoundException;
import com.walaszczyk.contactmanager.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contacts")
public class ContactsController {

    private ContactService contactService;

    public ContactsController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    @GetMapping(value = "/{id}")
    public Contact getContact(@PathVariable Long id){
        return contactService.getContact(id).orElseThrow(() -> new ContactNotFoundException(id));
    }

    @PostMapping()
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }
}
