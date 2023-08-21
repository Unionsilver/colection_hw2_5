package com.example.colection_hw2_5.service;
import com.example.colection_hw2_5.employee.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, double salary);


    Employee removeEmployee(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName);

    Collection<Employee> printAllEmployee();

}
