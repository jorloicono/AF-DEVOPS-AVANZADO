package com.example.seccion2;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeRepositoryImpl;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BDoCallRealMethodTest {

    //dependencia
    EmployeeRepository repository;
    //System under Test
    EmployeeService service;

    @BeforeEach
    void setUp() {
        this.repository = mock(EmployeeRepositoryImpl.class); // implementación
        this.service = new EmployeeServiceImpl(this.repository);
    }

    @Test
    void findOneTest3() {

        Employee emp = new Employee(1L, "Prueba", 35);
        // when(this.repository.findOne(1L)).thenReturn(emp); // no llama al método real
        doCallRealMethod().when(repository).findOne(1L); // llama al método real

        Employee employee1 = service.findOne(1L);

        verify(repository).findOne(1L);
        assertEquals("Prueba", employee1.getName());


    }


}
