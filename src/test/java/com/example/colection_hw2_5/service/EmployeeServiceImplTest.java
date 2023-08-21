package com.example.colection_hw2_5.service;

import com.example.colection_hw2_5.employee.Employee;
import com.example.colection_hw2_5.exception.EmployeeNotFoundException;
import com.example.colection_hw2_5.exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private static final int EMPLOYEE_MAX_SIZE = 2;
    EmployeeServiceImpl underTest = new EmployeeServiceImpl();
    Employee employee = new Employee("ОЛЕКСАНДР",
            "ВЛАДИМИРОВИЧ", 1, 10000);
    Employee Alex1 = new Employee(
            " Alex1 ", " Alexandrov1 ", 1, 20000);
    Employee Alex2 = new Employee(
            " Alex2 ", " Alexandrov2 ", 1, 30000);
    Employee Alex3 = new Employee(
            " Alex3 ", " Alexandrov3 ", 3, 40000);

    Collection<Employee> employees = List.of(Alex1, Alex2, Alex3);

    @Test
    void addEmployee_employeeIsNotInMap_employeeAdded() {
        Employee result = underTest.addEmployee(Alex2.getFirstName(),
                Alex2.getLastName(), Alex2.getDepartment(), Alex2.getSalary());
        assertEquals(Alex2, result);
    }

    @Test
    void addEmployee_employeeIsInMap_throwsException() {
        for (int i = 0; i < EMPLOYEE_MAX_SIZE; i++) {
            underTest.addEmployee("Oleg", String.valueOf(i), 1, 2000);
        }
        EmployeeStorageIsFullException ex =
                assertThrows(EmployeeStorageIsFullException.class,
                        () -> underTest.addEmployee("Oleg", "Olegovich", 1, 2000));
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
    void removeEmployee_employeeIsInMap_employeeRemoveAndReturned() {
        underTest.addEmployee(Alex1.getFirstName(), Alex1.getLastName(), Alex1.getDepartment(), Alex1.getSalary());
        Employee result = underTest.removeEmployee(Alex1.getFirstName(), Alex1.getLastName());
        assertEquals(Alex1, result);
        assertFalse(underTest.printAllEmployee().contains(Alex1));
    }

    @Test
    void employee_employeeIsHashMap_employeeNotFoundAndReturn() {

        underTest.addEmployee(employee.getFirstName(), employee.getLastName(),
                employee.getDepartment(), employee.getSalary());

        Employee result = underTest.removeEmployee(employee.getFirstName(),
                employee.getLastName());
        assertEquals(employee, result);
        assertFalse(underTest.printAllEmployee().contains(employee));
    }

    @Test
    void searchEmployee_firstNameAndLastName_ReturnEmployee() {
        Employee addedEmployee = underTest.addEmployee("Oleg", "Olegovich", 1, 2000);
        Employee foundEmployee = underTest.searchEmployee("Oleg", "Olegovich");
        assertNotNull(foundEmployee);
        assertEquals(addedEmployee, foundEmployee);

    }

    @Test
    void printAllEmployee() {
        Employee employee1 = underTest.addEmployee("Oleg", "Olegovich", 1, 2000);
        Employee employee2 = underTest.addEmployee("Oleg2", "Olegovich2", 2, 3000);

        Collection<Employee> employees0 = underTest.printAllEmployee();
        assertEquals(2, employees0.size());
        assertTrue(employees0.contains(employee1));
        assertTrue(employees0.contains(employee2));


    }
}