package com.example.seccion3;

import com.example.demo.domain.Person;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.PersonService;
import com.example.demo.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CArgumentAnswerTest {


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

        LocalDate defaultBirth = LocalDate.of(1970, 1, 1);
        when(repository.save(any())).thenAnswer(invocation -> {
           Object[] args = invocation.getArguments();
           Person person = (Person) args[0];
           LocalDate birth = person.getBirthday() != null ? person.getBirthday() : defaultBirth;
           return new Person(UUID.randomUUID(), person.getName(), birth);
        });

        Person result = service.save(new Person(null, "Prueba", null));

        assertNotNull(result);
        assertEquals("Prueba", result.getName());
        assertEquals(defaultBirth, result.getBirthday());

    }
}
