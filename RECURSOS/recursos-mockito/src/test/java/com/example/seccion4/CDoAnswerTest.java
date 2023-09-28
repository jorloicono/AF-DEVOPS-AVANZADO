package com.example.seccion4;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CDoAnswerTest {

    //dependencia
    PersonRepository repository;
    //System under Test
    PersonService service;

    @BeforeEach
    void setUp() {
        this.repository = mock(PersonRepository.class);
        this.service = new PersonServiceImpl(this.repository);
    }

    @Test
    void name() {

        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Person person = (Person) args[0];
            String email = (String) args[1];
            person.setEmail(email);
            return null;
        }).when(repository).updateEmail(any(Person.class), any(String.class));

        Person person = new Person(null, "email@example.com", null);

        Person personModified = service.updateEmail(person,
                "nuevoemail@example.com");

        assertNotNull(personModified);
        assertEquals("nuevoemail@example.com", personModified.getEmail());

    }
}
