package com.virtusa.ExceptionHandler.controller;

import com.virtusa.ExceptionHandler.entity.Bike;
import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.DatabaseAuthondicationException;
import com.virtusa.ExceptionHandler.exeption.DatabaseLibraryException;
import com.virtusa.ExceptionHandler.exeption.InvalidIdException;
import com.virtusa.ExceptionHandler.service.Validation;
import com.virtusa.ExceptionHandler.service.VehicleService;

import java.io.PrintWriter;
import java.io.StringWriter;

public class VehicleController {

    public boolean saveBike(Vehicle vehicle) {
        boolean isSave = false;
        try {
            Bike bike = (Bike) vehicle;
            isSave = new Validation().isValidVehicle(vehicle);
            if (isSave)
                isSave = new VehicleService().saveVehicle(bike);


        } catch (ClassCastException classCastException) {
            isSave = false;
            System.err.println("Invalid Vehicle Casting " + "More :" + classCastException.getMessage());

        } catch (DatabaseAuthondicationException databaseAuthondicationExeption) {
            isSave = false;
            System.err.println("Invalid database Configuration  " + "More :" + databaseAuthondicationExeption.getMessage());

        } catch (DatabaseLibraryException databaseLibraryException) {
            isSave = false;
            System.err.println("missing database connector  " + "More :" + databaseLibraryException.getMessage());

        } catch (InvalidIdException invalidIdExeption) {
            isSave = false;
            System.err.println("missing database connector  " + "More :" + invalidIdExeption.getMessage());

        } catch (RuntimeException runtimeException) {
            isSave = false;
            System.err.println("missing database connector  " + "More :" + runtimeException.getMessage());

        } catch (Exception exception) {
            isSave = false;
            System.err.println("missing database connector  " + "More :" + exception.getMessage());

        }


        return isSave;
    }


}
