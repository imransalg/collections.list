package com.emp.employeeaccounting.controller;

import com.emp.employeeaccounting.model.Employee;
import com.emp.employeeaccounting.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firsName, @RequestParam("lastName") String lastName) {
        return employeeService.add(firsName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firsName, @RequestParam("lastName") String lastName) {
        return employeeService.remove(firsName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firsName, @RequestParam("lastName") String lastName) {
        return employeeService.find(firsName, lastName);
    }
    @GetMapping
    public List<Employee> list() {
        return employeeService.list();
    }
}
