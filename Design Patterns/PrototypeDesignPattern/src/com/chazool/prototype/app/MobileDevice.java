package com.chazool.prototype.app;

public class MobileDevice extends Device{

    private int noOfSim;
    /*
     megapixels
     */
    private int frontCameraSize;

    /*
     megapixels
     */
    private int backCameraSize;

    public int getNoOfSim() {
        return noOfSim;
    }

    public void setNoOfSim(int noOfSim) {
        this.noOfSim = noOfSim;
    }

    public int getFrontCameraSize() {
        return frontCameraSize;
    }

    public void setFrontCameraSize(int frontCameraSize) {
        this.frontCameraSize = frontCameraSize;
    }

    public int getBackCameraSize() {
        return backCameraSize;
    }

    public void setBackCameraSize(int backCameraSize) {
        this.backCameraSize = backCameraSize;
    }

    @Override
    public String toString() {

        return  super.toString()+ " MobileDevice{" +
                "noOfSim=" + noOfSim +
                ", frontCameraSize=" + frontCameraSize +
                ", backCameraSize=" + backCameraSize +
                '}';
    }
}
