package com.chazool.ExceptionHandler.controller;

import com.chazool.ExceptionHandler.entity.Bike;
import com.chazool.ExceptionHandler.entity.Vehicle;
import com.chazool.ExceptionHandler.exeption.DatabaseAuthondicationException;
import com.chazool.ExceptionHandler.exeption.DatabaseLibraryException;
import com.chazool.ExceptionHandler.exeption.InvalidIdException;
import com.chazool.ExceptionHandler.service.Validation;
import com.chazool.ExceptionHandler.service.VehicleService;

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
