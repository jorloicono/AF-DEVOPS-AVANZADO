package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Integer count() {
        return this.personRepository.count();
    }

    @Override
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Person findOne(UUID uuid) {
        return this.personRepository.findOne(uuid);
    }

    @Override
    public Optional<Person> findOneOptional(UUID uuid) {

        try{
            return Optional.of(this.personRepository.findOne(uuid));
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Person save(Person employee) {
        return this.personRepository.save(employee);
    }

    @Override
    public void saveAll(List<Person> employees) {
        this.personRepository.saveAll(employees);
    }

    @Override
    public boolean delete(UUID uuid) {
        return this.personRepository.delete(uuid);
    }

    @Override
    public void deleteAll() {
        this.personRepository.deleteAll();
    }

    @Override
    public Person updateEmail(Person person, String email) {
        this.personRepository.updateEmail(person, email);
        return person;
    }
}
