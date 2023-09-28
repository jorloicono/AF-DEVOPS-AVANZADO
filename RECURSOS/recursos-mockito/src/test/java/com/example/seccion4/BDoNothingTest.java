package com.example.seccion4;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BDoNothingTest {

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
    @DisplayName("")
    void name() {

        doNothing().when(repository).deleteAll();

        service.deleteAll();
        service.deleteAll();

        verify(repository, times(2)).deleteAll();


    }
}
