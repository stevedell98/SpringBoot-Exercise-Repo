package com.general_exercise.exercise.ExceptionHandling;

import com.general_exercise.exercise.entity.Car;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ErrorGlobalHandling {
    @ExceptionHandler
    ResponseEntity<CarErrorResponse> httpInfo(CarNotFoundException exc){

        CarErrorResponse error = new CarErrorResponse();

        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        error.setCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
    }
}
