package com.walaszczyk.contactmanager.controller;

import com.walaszczyk.contactmanager.domain.Contact;
import com.walaszczyk.contactmanager.exceptions.ContactNotFoundException;
import com.walaszczyk.contactmanager.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/contacts")
@CrossOrigin
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
    public ResponseEntity<?> addContact(@RequestBody Contact newContact) {
        Contact addedContact = contactService.addContact(newContact);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(addedContact.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{id}")
    public Contact updateContact(@RequestBody Contact newContact, @PathVariable Long id){
        return contactService.updateContact(newContact, id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable Long id){
        return contactService.deleteContact(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
