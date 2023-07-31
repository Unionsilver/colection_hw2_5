package com.example.colection_hw2_5.Controller;

import com.example.colection_hw2_5.Employee.Employee;
import com.example.colection_hw2_5.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/max-size")
    public Employee findMaxSalaryOfEmployee(@RequestParam int department) {
        return departmentService.findMaxSalaryEm(department);
    }
    @GetMapping("/min-size")
    public Employee findMinSalaryOfEmployee(@RequestParam int department) {
        return departmentService.findMinSalaryEm(department);
    }
    @GetMapping("/all-size")
    public Collection<Employee> getAllEmployee(@RequestParam int department) {
        return departmentService.getAllEm(department);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeeTotal() {
        return departmentService.getAllGroupingByDepartmentEm();
    }
}
