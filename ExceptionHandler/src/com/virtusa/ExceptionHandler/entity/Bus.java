package com.virtusa.ExceptionHandler.entity;

public class Bus extends   Vehicle {

    @Override
    public double getParkingPrice(int  specialPrice) throws ArithmeticException{

        double priceA = 200 / specialPrice;
        double priceB = priceA * 2;
        return priceB;
    }


    @Override
    public double getServicePrice(int specialPrice) throws ArithmeticException {

        double priceA = 300 / specialPrice;
        double priceB = priceA * 2;
        return priceB;
    }


}
