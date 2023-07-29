package com.example.colection_hw2_5.Employee;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;
@ResponseStatus

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int department;
    private final double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Имя -  " + getFirstName() + "Фамилия - " + getLastName() +
                "Отдел" + getDepartment() + "Зарплата - " + getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }

    public String getFirstName() {

        return this.firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

}