package com.example.colection_hw2_5;

import com.example.colection_hw2_5.Exception.EmployeeAlreadyAddedException;
import com.example.colection_hw2_5.Exception.EmployeeNotFoundException;
import com.example.colection_hw2_5.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;

    private static final int EMPLOYEE_MAX_SIZE = 10;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        if (employeeMap.size() == EMPLOYEE_MAX_SIZE)
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");

        Employee employee = new Employee(firstName, lastName);
        String key = firstName + lastName;
        if (employeeMap.containsKey(key))
            throw new EmployeeAlreadyAddedException("Одинаковый сотрудник");
        employeeMap.put(key, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(firstName+lastName);
            if (employee == null) {
            throw new EmployeeNotFoundException("Не найден сотрудник что бы удалить");

        }
        return employee;
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(firstName+lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("Не найден сотрудник в поиске");
        }
        return employee;
    }

    @Override
    public Collection<Employee> printAllEmployee() {
        return employeeMap.values();
    }
}
