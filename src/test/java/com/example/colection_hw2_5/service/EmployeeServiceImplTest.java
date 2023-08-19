package com.example.colection_hw2_5.service;

import com.example.colection_hw2_5.employee.Employee;
import com.example.colection_hw2_5.exception.EmployeeNotFoundException;
import com.example.colection_hw2_5.exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("ОЛЕКСАНДР",
            "ВЛАДИМИРОВИЧ", 1 , 10000);
    Employee Alex1 = new Employee(
            " Alex1 ", " Alexandrov1 ", 1, 20000);
    Employee Alex2 = new Employee(
            " Alex2 ", " Alexandrov2 ", 1, 30000);
    Employee Alex3 = new Employee(
            " Alex3 ", " Alexandrov3 ", 3, 40000);

    Collection<Employee> employees = List.of(Alex1,Alex2,Alex3);
    @Test
    void addEmployee_employeeIsInMap_EmployeeAdded() {
        EmployeeNotFoundException ex =
                assertThrows(EmployeeNotFoundException.class,
                        () -> underTest.addEmployee("hi,","bye" ,1, 10000));
        assertEquals("Превышен лимит сотрудников", ex.getMessage());
    }

    @Test
    void removeEmployee_employeeIsNotInMap_employeeNotFoundException() {
        EmployeeNotFoundException ex =
        assertThrows(EmployeeNotFoundException.class,
        () -> underTest.removeEmployee(" Олександр ",
                " Владимирович "));
        assertEquals("Не найден сотрудник что бы удалить", ex.getMessage());
    }
    @Test
    void employee_employeeIsHashMap_employeeNotFoundAndReturn () {

        underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());

        Employee result = underTest.removeEmployee(employee.getFirstName(),
                employee.getLastName());
        assertEquals(employee, result);
        assertFalse(underTest.printAllEmployee().contains(employee));
    }

    @Test
    void searchEmployee() {
    }

    @Test
    void printAllEmployee() {
    }
}