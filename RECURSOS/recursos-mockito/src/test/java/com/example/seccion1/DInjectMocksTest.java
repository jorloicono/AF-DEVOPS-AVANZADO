package com.example.seccion1;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class) // opcion 1
public class DInjectMocksTest {

    // dependencia
    @Mock
    private EmployeeRepository repository;

    // class under test
    // system under test (sut)
    @InjectMocks
    private EmployeeServiceImpl service;

    @BeforeEach
    void setUp() { // opcion 2
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findOneTest() {

        // given
        Employee emp = new Employee(1L, "Emp1", 40);
        when(this.repository.findOne(anyLong())).thenReturn(emp);

        // when
        Employee employee = this.service.findOne(1L);
        Employee employee2 = this.service.findOne(2L);
        Employee employee3 = this.service.findOne(600L);

        // then
        assertNotNull(employee);
        assertNotNull(employee2);
        assertNotNull(employee3);
        assertEquals("Emp1", employee.getName());
        assertEquals("Emp1", employee2.getName());
        assertEquals("Emp1", employee3.getName());



    }



}
