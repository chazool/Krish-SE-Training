package com.chazool.prototype.app;

public class Laptop extends Computer{

    private boolean isFullKeyboard;
    private double screenSize;

    public boolean isFullKeyboard() {
        return isFullKeyboard;
    }

    public void setFullKeyboard(boolean fullKeyboard) {
        isFullKeyboard = fullKeyboard;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return  super.toString() +" Laptop{" +
                "isFullKeyboard=" + isFullKeyboard +
                ", screenSize=" + screenSize +
                '}';
    }
}
