package com.ev.BatteryStation.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static String NOT_FOUND = "Station not found";
    private final static String BAD_REQUEST = "Invalid Request";
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<>(NOT_FOUND, HttpStatus.NOT_FOUND);
    }
    public ResponseEntity handleInvalidParamException(InvalidParamException invalidParamException){
        return new ResponseEntity<>(BAD_REQUEST,HttpStatus.BAD_REQUEST);
    }


}
