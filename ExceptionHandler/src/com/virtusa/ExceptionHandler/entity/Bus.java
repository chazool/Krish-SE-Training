package com.chazool.ExceptionHandler.entity;

public class Bus extends   Vehicle {

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
