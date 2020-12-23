package com.virtusa.prototype.app;

public class Computer  extends Device{

    private int noOfRamSlots;

    public int getNoOfRamSlots() {
        return noOfRamSlots;
    }

    public void setNoOfRamSlots(int noOfRamSlots) {
        this.noOfRamSlots = noOfRamSlots;
    }

    @Override
    public String toString() {
        return super.toString() +"Computer{" +
                "noOfRamSlots=" + noOfRamSlots +
                '}';
    }
}
