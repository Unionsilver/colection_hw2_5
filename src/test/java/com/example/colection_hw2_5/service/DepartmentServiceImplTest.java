package com.example.colection_hw2_5.service;

import com.example.colection_hw2_5.employee.Employee;
import com.example.colection_hw2_5.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentServiceImpl underTest;
    Employee Alex1 = new Employee(
            " Alex1 ", " Alexandrov1 ", 1, 20000);
    Employee Alex2 = new Employee(
            " Alex2 ", " Alexandrov2 ", 1, 30000);
    Employee Alex3 = new Employee(
            " Alex3 ", " Alexandrov3 ", 3, 40000);

    Collection<Employee> employees = List.of(Alex1,Alex2,Alex3);

    @Test
    void findMaxSalaryEm_employeeFind_returnEmployeeWithMaxSalary() {
        when(employeeService.printAllEmployee()).thenReturn(employees);
        Employee result = underTest.findMaxSalaryEm(1);
        assertEquals(Alex2, result);
    }
    @Test
    void findMaxSalaryEm_employeeNotFind_trowEmployeeNotFoundException() {
        int department = 1;
        when(employeeService.printAllEmployee()).thenReturn(Collections.emptyList());
        EmployeeNotFoundException ex = assertThrows(EmployeeNotFoundException.class,
        () -> underTest.findMaxSalaryEm(department));
        assertEquals("нет сотрудников в отделе" + department, ex.getMessage());
    }

    @Test
    void findMinSalaryEm_employeeFind_returnEmployeeWithMinSalary() {
        when(employeeService.printAllEmployee()).thenReturn(employees);
        Employee result = underTest.findMinSalaryEm(1);
        assertEquals(Alex2, result);
    }
    @Test
    void findMinSalaryEm_employeeNotFind_trowEmployeeNotFoundException() {
        int department = 1;
        when(employeeService.printAllEmployee()).thenReturn(Collections.emptyList());
        EmployeeNotFoundException ex = assertThrows(EmployeeNotFoundException.class,
                () -> underTest.findMinSalaryEm(department));
        assertEquals("нет сотрудников в отделе" + department, ex.getMessage());
    }

    @Test
    void getAllEm_shouldReturnListOfAllDepartment() {
    }

    @Test
    void getAllGroupingByDepartmentEm() {
    }
}