package com.example.demo.service;

import com.example.demo.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonService {

    Integer count();

    List<Person> findAll();

    Person findOne(UUID uuid);

    Optional<Person> findOneOptional(UUID uuid);

    void saveAll(List<Person> employees);

    Person updateEmail(Person person, String email);

    Person save(Person employee);

    boolean delete(UUID uuid);

    void deleteAll();
}
