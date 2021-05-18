package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/home/employee")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list";
    }
}
