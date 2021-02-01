package com.chazool.prototype.app;

import com.chazool.prototype.exception.DeviceCloneNotSupportedException;

import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) {
        String errorMessage = null;
        try {
            DeviceRegistry deviceRegistry = new DeviceRegistry();

            // Mobile Device - Object 1
            MobileDevice mobileDevice1 = (MobileDevice) deviceRegistry.getDevice(DeviceType.MobileDevice);
            mobileDevice1.setDeviceCode(001);
            mobileDevice1.setBrandName("Apple");
            mobileDevice1.setPrice(new BigDecimal("50000.00"));
            mobileDevice1.setBackCameraSize(12);
            mobileDevice1.setFrontCameraSize(5);
            mobileDevice1.setNoOfSim(1);

            // Mobile Device - Object 2
            MobileDevice mobileDevice2 = (MobileDevice) deviceRegistry.getDevice(DeviceType.MobileDevice);
            mobileDevice2.setDeviceCode(002);
            mobileDevice2.setBrandName("Samsung");
            mobileDevice2.setPrice(new BigDecimal("40000.00"));
            mobileDevice2.setBackCameraSize(10);
            mobileDevice2.setFrontCameraSize(3);
            mobileDevice2.setNoOfSim(2);

            System.out.println(mobileDevice1);
            System.out.println(mobileDevice2);
        } catch (DeviceCloneNotSupportedException cloneNotSupportedException) {
            errorMessage = cloneNotSupportedException.getMessage();
        } finally {
            if (errorMessage != null)
                System.out.println(errorMessage);
        }


    }
}
