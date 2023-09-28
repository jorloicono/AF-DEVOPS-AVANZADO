package com.example.demo.service;

import com.example.demo.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Integer count();

    List<Employee> findAll();

    Employee findOne(Long id);

    Optional<Employee> findOneOptional(Long id);

    Employee save(Employee employee);

    void saveAll(List<Employee> employees);

    boolean delete(Long id);

    void deleteAll();
}
