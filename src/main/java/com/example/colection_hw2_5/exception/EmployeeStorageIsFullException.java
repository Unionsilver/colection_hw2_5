package com.example.colection_hw2_5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason =  "haha")
public class EmployeeStorageIsFullException extends RuntimeException{
    public  EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
