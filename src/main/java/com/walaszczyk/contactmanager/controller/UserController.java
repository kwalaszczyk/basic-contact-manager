package com.walaszczyk.contactmanager.controller;

import com.walaszczyk.contactmanager.dto.UserDataDTO;
import com.walaszczyk.contactmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> singUp(@RequestBody UserDataDTO user){
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<?> testUser(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return new ResponseEntity<>("JEST GIT", HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> testAdmin(){
        return new ResponseEntity<>("JEST GIT ADMIN", HttpStatus.OK);
    }

}
