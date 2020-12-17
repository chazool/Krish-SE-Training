package com.virtusa.ExceptionHandler.service;

import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.InvalidIdException;

public class Validation {

    public boolean isValidVehicle(Vehicle vehicle) throws InvalidIdException {
        boolean isValid = false;
        if (vehicle.no <= 0) {
            isValid = false;
            throw new InvalidIdException("This ID is Invalid ");
        } else {
            isValid = true;
        }

        return isValid;
    }


}
