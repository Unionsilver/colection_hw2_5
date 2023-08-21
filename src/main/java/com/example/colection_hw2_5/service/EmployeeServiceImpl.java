package com.example.colection_hw2_5.service;

import com.example.colection_hw2_5.employee.Employee;
import com.example.colection_hw2_5.exception.EmployeeAlreadyAddedException;
import com.example.colection_hw2_5.exception.EmployeeNotFoundException;
import com.example.colection_hw2_5.exception.EmployeeStorageIsFullException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;

    private static final int EMPLOYEE_MAX_SIZE = 2;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {

        if (employeeMap.size() == EMPLOYEE_MAX_SIZE)
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");

        Employee employee = new Employee(
                StringUtils.capitalize(firstName),
                StringUtils.capitalize(lastName),
                department,
                salary);
        String key = generateKey(firstName, lastName);

        if (employeeMap.containsKey(key))
            throw new EmployeeAlreadyAddedException("Одинаковый сотрудник");
        employeeMap.put(key, employee);
        return employee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(generateKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException("Не найден сотрудник что бы удалить");

        }
        return employee;
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(generateKey(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException("Не найден сотрудник в поиске");
        }
        return employee;
    }

    @Override
    public Collection<Employee> printAllEmployee() {
        return employeeMap.values();
    }
    private String generateKey(String firstName, String lastName){
        return firstName + lastName;

    }
}
