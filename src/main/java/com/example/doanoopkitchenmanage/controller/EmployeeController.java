package com.example.doanoopkitchenmanage.controller;

import com.example.doanoopkitchenmanage.model.Employee;
import com.example.doanoopkitchenmanage.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    //-----HOME PAGE
    @GetMapping("/home/employee")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list";
    }
    //-----CREATE NEW EMPLOYEE
    @GetMapping("/home/employee/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }
    @PostMapping("/home/employee/save")
    public String save(Employee employee, RedirectAttributes redirectAttributes) {

        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message","Created employee successfully!");
        return "redirect:/home/employee";
    }

    //-----EDIT EMPLOYEE
    @GetMapping("/home/employee/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employeeService.findById(id));
        return modelAndView;
    }

}
