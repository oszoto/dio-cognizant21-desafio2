package com.ozoto.diocognizantproj2.service;

import com.ozoto.diocognizantproj2.dto.request.PersonDTO;
import com.ozoto.diocognizantproj2.dto.response.MessageResponseDTO;
import com.ozoto.diocognizantproj2.entity.Person;
import com.ozoto.diocognizantproj2.mapper.PersonMapper;
import com.ozoto.diocognizantproj2.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID = " + savedPerson.getId()).build();
    }
}
