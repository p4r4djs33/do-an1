package com.example.doanoopkitchenmanage.service.employee;

import com.example.doanoopkitchenmanage.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
