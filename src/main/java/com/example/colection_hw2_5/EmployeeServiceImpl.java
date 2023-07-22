package com.example.colection_hw2_5;

import com.example.colection_hw2_5.Exception.EmployeeAlreadyAddedException;
import com.example.colection_hw2_5.Exception.EmployeeNotFoundException;
import com.example.colection_hw2_5.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    private static final int EMPLOYEE_MAX_SIZE = 10;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() == EMPLOYEE_MAX_SIZE)
            throw new EmployeeStorageIsFullException("Превышен лимит сотрудников");

        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee))
            throw new EmployeeAlreadyAddedException("Одинаковый сотрудник");
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Не найден сотрудник что бы удалить");

        }
        return employee;
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Не найден сотрудник в поиске");
        }
        return employee;
    }
    @Override
    public List<Employee> printAllEmployee (){
        return employees;
    }
}
