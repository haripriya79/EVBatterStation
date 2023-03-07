package com.ev.BatteryStation.Exceptions;

public class InvalidParamException extends RuntimeException{
    private String message;
    public InvalidParamException(String message){
        super(message);
        this.message = message;
    }
    public InvalidParamException(){

    }
}
