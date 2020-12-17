package com.virtusa.ExceptionHandler.service;

import com.virtusa.ExceptionHandler.dao.VehicleDatabaseOppression;
import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.DatabaseAuthondicationException;
import com.virtusa.ExceptionHandler.exeption.DatabaseLibraryException;
import com.virtusa.ExceptionHandler.exeption.InvalidIdException;

public class VehicleService {


    public boolean saveVehicle(Vehicle vehicle) throws DatabaseAuthondicationException, DatabaseLibraryException, InvalidIdException {
        boolean isValid = new Validation().isValidVehicle(vehicle);
        boolean isSave = false;
        if (isValid) {
            isSave = new VehicleDatabaseOppression().saveVehicle(vehicle);
        }
        return isSave;
    }



}
