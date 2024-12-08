package com.luv2code.cruddemo.exceptionHandling;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
