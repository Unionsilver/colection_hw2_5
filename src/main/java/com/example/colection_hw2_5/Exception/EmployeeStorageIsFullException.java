package com.example.colection_hw2_5.Exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public  EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
