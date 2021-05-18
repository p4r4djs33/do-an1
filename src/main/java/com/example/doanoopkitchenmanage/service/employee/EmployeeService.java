package com.example.doanoopkitchenmanage.service.employee;

import com.example.doanoopkitchenmanage.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

void save (Employee employee);

Optional<Employee> findById(Long id);

void remove(Long id);
}
