package com.example.colection_hw2_5.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason =  "haha")
public class EmployeeNotFoundException extends RuntimeException{
    public  EmployeeNotFoundException(String message) {
        super(message);
    }
}
