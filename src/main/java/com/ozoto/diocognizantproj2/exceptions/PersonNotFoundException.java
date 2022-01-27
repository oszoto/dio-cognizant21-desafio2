package com.ozoto.diocognizantproj2.exceptions;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(Long id) {
        super("Person not found with ID: " + id);
    }
}
