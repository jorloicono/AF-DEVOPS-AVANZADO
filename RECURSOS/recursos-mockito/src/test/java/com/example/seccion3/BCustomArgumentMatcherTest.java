package com.example.seccion3;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BCustomArgumentMatcherTest {

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
    void findOneTest() {

        // service
        service.saveAll(List.of(
                new Employee(1L, "empleado 1", 30),
                new Employee(2L, "empleado 2", 30),
                new Employee(3L, "empleado 3", 30),
                new Employee(4L, "empleado 3", 30)
                ));

        // verify
        verify(repository).saveAll(argThat(list -> list.size() == 4));

    }
}
