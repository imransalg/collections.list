package com.emp.employeeaccounting.service;

import com.emp.employeeaccounting.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    List<Employee> list();
}
