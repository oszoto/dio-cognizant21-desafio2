package com.ozoto.diocognizantproj2.controller;

import javax.validation.Valid;

import com.ozoto.diocognizantproj2.dto.request.PersonDTO;
import com.ozoto.diocognizantproj2.dto.response.MessageResponseDTO;
import com.ozoto.diocognizantproj2.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO person) {
        return personService.createPerson(person);
    }

    @GetMapping
    public String getTest() {
        return "Teste";
    }
}
