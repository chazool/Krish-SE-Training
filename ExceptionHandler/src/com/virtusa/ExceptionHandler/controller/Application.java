package com.virtusa.ExceptionHandler.controller;

import com.virtusa.ExceptionHandler.entity.Bike;
import com.virtusa.ExceptionHandler.entity.Vehicle;
import com.virtusa.ExceptionHandler.exeption.DatabaseAuthondicationExeption;
import com.virtusa.ExceptionHandler.exeption.DatabaseLibraryException;
import com.virtusa.ExceptionHandler.exeption.InvalidIdExeption;

public class Application {

    public static void main(String[] args) {
        try {
            Vehicle bike = new Bike();
            //   bike.setNo(121);
            bike.setNo(0);
            bike.setOwnerName("Amal Perera");
            bike.setBrand("Bajaj");
            bike.setOwnerNic("800618040V");

            VehicleController vehicleController = new VehicleController();
            vehicleController.saveBike(bike);
        } catch (ClassCastException classCastException) {
            System.out.println("Invalid Vehicle Casting " + "More :" + classCastException.getMessage());

        } catch (DatabaseAuthondicationExeption databaseAuthondicationExeption) {
            System.out.println("Invalid database Configuration  " + "More :" + databaseAuthondicationExeption.getMessage());

        } catch (DatabaseLibraryException databaseLibraryException) {
            System.out.println("missing database connector  " + "More :" + databaseLibraryException.getMessage());

        } catch (InvalidIdExeption invalidIdExeption) {
            System.out.println("Invalid Vehicle Id " + "More :" + invalidIdExeption.getMessage());
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }


}
