package com.virtusa.ExceptionHandler.entity;

public abstract class Vehicle {

    public  String brand = null;
    public  int no = -1;
    public  String OwnerNic = null;
    public  String ownerName = null;
    public  int engineCapacity = -1;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getOwnerNic() {
        return OwnerNic;
    }

    public void setOwnerNic(String ownerNic) {
        OwnerNic = ownerNic;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public abstract double getParkingPrice(int  specialPrice) throws ArithmeticException;
    public abstract double getServicePrice(int specialPrice )throws ArithmeticException;
}
