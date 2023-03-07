package com.ev.BatteryStation.Validation;

public class Validation {
    public static boolean validateId(String stationId){
        try{
            Long Id = Long.parseLong(stationId);
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
}
