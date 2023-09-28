package com.example.seccion1;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class EExceptionsTest {

    //dependencia
    EmployeeRepository repository;
    //System under Test
    EmployeeService service;

    @BeforeEach
    void setUp() {
        this.repository = mock(EmployeeRepository.class);
        this.service = new EmployeeServiceImpl(this.repository);
    }

    @Test
    void checkException() {

        when(this.repository.findOne(any())).thenThrow(new IllegalArgumentException());

        Optional<Employee> resultOpt = this.service.findOneOptional(1L);

        assertNotNull(resultOpt);
        assertFalse(resultOpt.isPresent()); // comprobar que está vacío

    }

    @Test
    void checkException2() {

        when(this.repository.findOne(any())).thenThrow(new NoSuchElementException());

        assertThrows(NoSuchElementException.class, () -> this.service.findOneOptional(1L));


    }
}
