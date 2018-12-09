package com.walaszczyk.contactmanager.aspects;

import com.walaszczyk.contactmanager.exceptions.ContactNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ContactNotFoundAspect {
    @ResponseBody
    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String contactNotFoundHandler(ContactNotFoundException ex){
        return ex.getMessage();
    }
}
