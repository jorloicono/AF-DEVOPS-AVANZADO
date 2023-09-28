package com.example.seccion4;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ADoThrowTest {

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
    void name() {

        doThrow(new RuntimeException()).when(repository).saveAll(anyList());

        assertThrows(RuntimeException.class, () ->
                service.saveAll(List.of(
                        new Employee(1L, "e1", 30),
                        new Employee(2L, "e2", 30)
                )));
    }
}
