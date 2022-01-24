package com.ozoto.diocognizantproj2.controller;

import com.ozoto.diocognizantproj2.dto.MessageResponseDTO;
import com.ozoto.diocognizantproj2.entity.Person;
import com.ozoto.diocognizantproj2.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person with ID = " + savedPerson.getId()).build();
    }
}
