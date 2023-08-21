package com.example.colection_hw2_5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "k")
public class EmployeeAlreadyAddedException extends RuntimeException{
    public  EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
