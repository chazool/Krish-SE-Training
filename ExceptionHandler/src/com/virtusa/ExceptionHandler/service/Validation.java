package com.virtusa.ExceptionHandler.service;

import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.InvalidIdExeption;

public class Validation {

    public boolean isValidVehicle(Vehicle vehicle) throws InvalidIdExeption {
        boolean bool = false;
        if (vehicle.no <= 0) {
            bool = false;
            throw new InvalidIdExeption("This ID is Invalid ");
        }else{
            bool=true;
        }

        return bool;
    }


}
