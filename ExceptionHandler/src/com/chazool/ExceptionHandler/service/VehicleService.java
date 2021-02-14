package com.chazool.ExceptionHandler.service;

import com.chazool.ExceptionHandler.dao.VehicleDatabaseOppression;
import com.chazool.ExceptionHandler.entity.Vehicle;
import com.chazool.ExceptionHandler.exeption.DatabaseAuthondicationException;
import com.chazool.ExceptionHandler.exeption.DatabaseLibraryException;
import com.chazool.ExceptionHandler.exeption.InvalidIdException;

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
