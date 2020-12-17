package com.virtusa.ExceptionHandler.entity;

public class Bike extends Vehicle {



    @Override
    public double getParkingPrice(int specialPrice) throws ArithmeticException {

        double price1 = 200 / specialPrice;
        double price2 = price1 * 2;
        return price2;
    }


    @Override
    public double getServicePrice(int specialPrice) throws ArithmeticException {

        double price1 = 300 / specialPrice;
        double price2 = price1 * 2;
        return price2;
    }

}
