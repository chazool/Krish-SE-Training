package com.virtusa.ExceptionHandler.service;

import com.virtusa.ExceptionHandler.dao.VehicleDatabaseOppression;
import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.DatabaseAuthondicationExeption;
import com.virtusa.ExceptionHandler.exeption.DatabaseLibraryException;
import com.virtusa.ExceptionHandler.exeption.InvalidIdExeption;

public class VehicleService {


    public boolean saveVehicle(Vehicle vehicle) throws DatabaseAuthondicationExeption, DatabaseLibraryException, InvalidIdExeption {
        boolean isValid = new Validation().isValidVehicle(vehicle);
        boolean isSave = false;
        if (isValid) {
            isSave = new VehicleDatabaseOppression().saveVehicle(vehicle);
        }
        return isSave;
    }



}
