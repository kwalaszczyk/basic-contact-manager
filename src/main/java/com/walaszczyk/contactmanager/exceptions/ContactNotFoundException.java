package com.walaszczyk.contactmanager.exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(Long id) {
        super("Could not found contact " + id);
    }
}
