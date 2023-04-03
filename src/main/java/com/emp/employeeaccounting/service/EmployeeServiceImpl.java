package com.emp.employeeaccounting.service;

import com.emp.employeeaccounting.exeptions.EmployeeAlreadyAddedException;
import com.emp.employeeaccounting.exeptions.EmployeeNotFoundException;
import com.emp.employeeaccounting.exeptions.EmployeeStorageIsFullException;
import com.emp.employeeaccounting.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int size = 5;
    private final List<Employee> employees = new ArrayList<>(size);

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < size) {
            for (Employee emp : employees) {
                if (emp.equals(employee)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}
