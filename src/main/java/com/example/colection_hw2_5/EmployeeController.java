package com.example.colection_hw2_5;

import com.example.colection_hw2_5.Exception.EmployeeNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseStatus

@RequestMapping("/firstPage")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/employee/add?firstName=Ivan&lastName=Ivanov")
    public String addPerson(@RequestParam ("firstName") String firstName,
                            @RequestParam ("lastName") String lastName) {
        return employeeService.addPerson(firstName, lastName);
    }

    @RequestMapping(path = "/employee/remove?firstName=Ivan&lastName=Ivanov")
    public String removeWorkers(@RequestParam ("firstName")  String firstName,
                                @RequestParam ("lastName") String lastName) {
        return  employeeService.removeWorkers(firstName, lastName);
    }

    @RequestMapping(path = "/employee/find?firstName=Ivan&lastName=Ivanov")
    public String searchWorkers(@RequestParam ("firstName")  String firstName,
                                @RequestParam ("lastName") String lastName) {
        try {
            return employeeService.searchWorkers(firstName, lastName);
        } catch (EmployeeNotFoundException ex) {
            return ex.getMessage();
        }
    }
}
