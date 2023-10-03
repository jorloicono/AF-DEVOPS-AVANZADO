package com.example.seccion1;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EMockVsSpyTest {

    //dependencia
    EmployeeRepository repository;
    //System under Test
    EmployeeService service;

    @BeforeEach
    void setUp() {
        this.repository = spy(EmployeeRepositoryImpl.class);
        this.service = new EmployeeServiceImpl(this.repository);
    }

    @Test
    void findOneTest() {

        Employee employee1 = service.findOne(1L);

        verify(repository).findOne(1L);

    }

    @Test
    void findOneTest2() {

        Employee emp = new Employee(1L, "Prueba", 35);
        when(repository.findOne(1L)).thenReturn(emp);

        Employee employee1 = service.findOne(1L);
        assertEquals("Prueba", employee1.getName());

        verify(repository).findOne(1L);

    }

    @Test
    void findOneTest3() {

        Employee emp = new Employee(1L, "Prueba", 35);
        doReturn(emp).when(repository).findOne(1L);

        Employee employee1 = service.findOne(1L);
        assertEquals("Prueba", employee1.getName());

        verify(repository).findOne(1L);

    }

}
