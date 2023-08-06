package com.example.colection_hw2_5.service;

import com.example.colection_hw2_5.employee.Employee;
import com.example.colection_hw2_5.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalaryEm(int department) {
        return employeeService.printAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("нет сотрудников в отделе" + department));
    }

    @Override
    public Employee findMinSalaryEm(int department) {
        return employeeService.printAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("нет сотрудников в отделе" + department));
    }

    @Override
    public Collection<Employee> getAllEm(int department) {
        return employeeService.printAllEmployee().stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllGroupingByDepartmentEm() {
        return employeeService.printAllEmployee().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
