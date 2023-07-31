package com.example.colection_hw2_5.Service;
import com.example.colection_hw2_5.Employee.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee removeEmployee(String firstName, String lastName, int department, double salary);

    Employee searchEmployee(String firstName, String lastName);

    Collection<Employee> printAllEmployee();
}
