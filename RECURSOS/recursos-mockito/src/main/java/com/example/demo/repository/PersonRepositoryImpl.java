package com.example.demo.repository;

import com.example.demo.domain.Person;

import java.time.LocalDate;
import java.util.*;

public class PersonRepositoryImpl implements PersonRepository{
    private final Map<UUID, Person> persons = new HashMap<>();

    public PersonRepositoryImpl() {

        // demo data
        Person emp1 = new Person(UUID.randomUUID(), "Person1", LocalDate.now());
        Person emp2 = new Person(UUID.randomUUID(), "Person2", LocalDate.now());
        Person emp3 = new Person(UUID.randomUUID(), "Person3", LocalDate.now());

        persons.put(emp1.getUuid(), emp1);
        persons.put(emp2.getUuid(), emp2);
        persons.put(emp3.getUuid(), emp3);
    }

    @Override
    public Integer count() {
        return persons.keySet().size();
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons.values());
    }

    @Override
    public Person findOne(UUID uuid) {
        System.out.println("PersonRepositoryImpl ejecutando findOne para " + uuid);
        if (uuid == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo !");
        }
        return persons.get(uuid);
    }

    @Override
    public Person save(Person person) {
        // asignar un id
        if (person.getUuid() == null) // nuevo Person
            person.setUuid(UUID.randomUUID()); // genera id y lo asigna

        persons.remove(person.getUuid());

        persons.put(person.getUuid(), person);
        return person;
    }

    @Override
    public void saveAll(List<Person> persons) {
        persons.forEach(this::save);
    }

    @Override
    public void updateEmail(Person person, String email) {
        person.setEmail(email);
        // actualiza en db
        //...
    }

    /**
     *
     */
    @Override
    public boolean delete(UUID id) {
        if (id == null || !persons.containsKey(id))
            return false;
        persons.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!persons.isEmpty())
            persons.clear();
    }


}
