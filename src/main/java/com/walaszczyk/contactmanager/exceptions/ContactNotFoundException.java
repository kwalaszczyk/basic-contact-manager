package com.walaszczyk.contactmanager.exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(Long id) {
        super("Cound not found contact " + id);
    }
}
