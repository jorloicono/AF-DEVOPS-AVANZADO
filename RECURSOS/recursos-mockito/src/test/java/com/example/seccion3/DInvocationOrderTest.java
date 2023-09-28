package com.example.seccion3;

import com.example.demo.domain.Employee;
import com.example.demo.service.IRPFCalculator;
import com.example.demo.service.IVACalculator;
import com.example.demo.service.SalaryCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DInvocationOrderTest {

    // dependencias
    private IRPFCalculator irpfCalculator;
    private IVACalculator ivaCalculator;

    // system under test
    private SalaryCalculatorService service;


    @BeforeEach
    void setUp() {
        this.irpfCalculator = mock(IRPFCalculator.class);
        this.ivaCalculator = mock(IVACalculator.class);
        this.service = new SalaryCalculatorService(irpfCalculator, ivaCalculator);
    }

    @Test
    void name() {

        when(irpfCalculator.calculateIRPF(32000d)).thenReturn(4800d);
        when(ivaCalculator.calculateIVA(36800d)).thenReturn(7728d);

        Employee emp = new Employee(1L, "Emp", 20);
        double salary = this.service.calculateSalary(emp);

        InOrder inOrder = inOrder(irpfCalculator, ivaCalculator);

        inOrder.verify(irpfCalculator).calculateIRPF(32000);
        inOrder.verify(ivaCalculator).calculateIVA(36800d);



    }
}
