package com.example.demo.repository;

import com.example.demo.domain.Person;

import java.util.List;
import java.util.UUID;

public interface PersonRepository {

    Integer count();

    List<Person> findAll();

    Person findOne(UUID uuid);
    
    Person save(Person smartphone);
    void updateEmail(Person person, String email);


    void saveAll(List<Person> Persons);

    boolean delete(UUID id);

    void deleteAll();

}
