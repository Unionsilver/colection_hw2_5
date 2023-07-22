package com.example.colection_hw2_5;

import java.util.List;

public interface EmployeeService {

    List<Employee> employees = List.of();

    String employees(String firstName, String lastName);
    void addWorkers(String firstName, String lastName);
    String removeWorkers(String firstName, String lastName);
    String searchWorkers(String firstName, String lastName);
    void sameEmployee(String firstName, String lastName);

    String addPerson(String firstName, String lastName);
}
