package com.ozoto.diocognizantproj2.repository;

import com.ozoto.diocognizantproj2.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
