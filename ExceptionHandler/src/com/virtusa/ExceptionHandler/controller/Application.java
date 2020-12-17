package com.virtusa.ExceptionHandler.controller;

import com.virtusa.ExceptionHandler.entity.Bike;
import com.virtusa.ExceptionHandler.entity.Vehicle;

public class Application {

    public static void main(String[] args) {

        Vehicle bike = new Bike();
        bike.setNo(121);
        bike.setOwnerName("Amal Perera");
        bike.setBrand("Bajaj");
        bike.setOwnerNic("800618040V");

        VehicleController vehicleController = new VehicleController();
        boolean isSave = vehicleController.saveBike(bike);

        if(isSave)
            System.out.println("Record saved successfully");
        else
            System.out.println("Record saved Fail");


    }



}
