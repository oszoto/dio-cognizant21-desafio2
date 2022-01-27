package com.ozoto.diocognizantproj2.service;

import java.util.List;
import java.util.stream.Collectors;

import com.ozoto.diocognizantproj2.dto.request.PersonDTO;
import com.ozoto.diocognizantproj2.dto.response.MessageResponseDTO;
import com.ozoto.diocognizantproj2.entity.Person;
import com.ozoto.diocognizantproj2.exceptions.PersonNotFoundException;
import com.ozoto.diocognizantproj2.mapper.PersonMapper;
import com.ozoto.diocognizantproj2.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    private void assertExistsId(Long id) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createResponseMessage(String message, Long id) {
        return MessageResponseDTO.builder().message(message + id).build();
    }

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDto) {
        Person personToSave = personMapper.toModel(personDto);

        Person savedPerson = personRepository.save(personToSave);
        return createResponseMessage("Created person with ID = ", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDto) throws PersonNotFoundException {
        this.assertExistsId(id);
        Person personToUpdate = personMapper.toModel(personDto);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createResponseMessage("Updated person with ID = ", updatedPerson.getId());
    }

    public void delete(Long id) throws PersonNotFoundException {
        this.assertExistsId(id);
        personRepository.deleteById(id);
    }
}
