package com.walaszczyk.contactmanager.dto;

import com.walaszczyk.contactmanager.domain.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDataDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<Role> roles;
}
