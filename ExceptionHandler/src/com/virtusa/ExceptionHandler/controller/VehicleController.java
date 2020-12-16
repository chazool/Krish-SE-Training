package com.virtusa.ExceptionHandler.controller;

import com.virtusa.ExceptionHandler.entity.Bike;
import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.DatabaseAuthondicationExeption;
import com.virtusa.ExceptionHandler.exeption.DatabaseLibraryException;
import com.virtusa.ExceptionHandler.exeption.InvalidIdExeption;
import com.virtusa.ExceptionHandler.exeption.InvalidVehicleCategoryExeption;
import com.virtusa.ExceptionHandler.service.Validation;
import com.virtusa.ExceptionHandler.service.VehicleService;

public class VehicleController {

    public boolean saveBike(Vehicle vehicle) throws InvalidVehicleCategoryExeption ,DatabaseAuthondicationExeption,DatabaseLibraryException,InvalidIdExeption {
        boolean isSave = false;
        try {
            Bike bike = (Bike) vehicle;
            isSave = new Validation().isValidVehicle(vehicle);
            isSave = new VehicleService().saveVehicle(bike);

        } catch (ClassCastException ex) {
            throw new InvalidVehicleCategoryExeption(" Vehicle  != Bike ",ex);
        }
        return isSave;
    }





}
