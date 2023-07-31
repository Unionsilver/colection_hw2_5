package com.example.colection_hw2_5.Controller;

import com.example.colection_hw2_5.Employee.Employee;
import com.example.colection_hw2_5.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/firstPage")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int department,
                        @RequestParam double salary) {
        return employeeService.addEmployee(firstName, lastName,department, salary );
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam int department,
                           @RequestParam double salary) {
        return employeeService.removeEmployee(firstName, lastName,department, salary);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName) {
        return employeeService.searchEmployee(firstName, lastName);
    }

    @GetMapping("/allWorkers")
    public Collection<Employee> findAllEmployee() {
        return employeeService.printAllEmployee();
    }
}

