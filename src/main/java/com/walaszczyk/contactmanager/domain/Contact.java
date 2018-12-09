package com.walaszczyk.contactmanager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
}
