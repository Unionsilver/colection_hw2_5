package com.example.colection_hw2_5;
import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName);

    Collection<Employee> printAllEmployee();
}
