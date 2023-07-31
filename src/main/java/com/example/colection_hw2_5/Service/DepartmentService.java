package com.example.colection_hw2_5.Service;

import com.example.colection_hw2_5.Employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryEm(int department);

    Employee findMinSalaryEm(int department);

    Collection<Employee> getAllEm(int department);

    Map<Integer, List<Employee>> getAllGroupingByDepartmentEm();
}
