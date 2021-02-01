package com.chazool.prototype.app;

import com.chazool.prototype.exception.DeviceCloneNotSupportedException;

import java.util.HashMap;
import java.util.Map;

public class DeviceRegistry {

    private Map<DeviceType, Device> devices = new HashMap<>();

    public DeviceRegistry() {
        this.initialize();
    }

    public void initialize() {
        //Objects
        MobileDevice mobileDevice = new MobileDevice();
        Computer computer = new Computer();
        Laptop laptop = new Laptop();

        devices.put(DeviceType.MobileDevice, mobileDevice);
        devices.put(DeviceType.Computer, computer);
        devices.put(DeviceType.Laptop, laptop);
    }

    public Device getDevice(DeviceType deviceType) throws DeviceCloneNotSupportedException {
        System.out.println(deviceType);
        Device device = null;
        try {
            device = (Device) devices.get(deviceType).clone();
        } catch (CloneNotSupportedException e) {
            throw new DeviceCloneNotSupportedException("Device type (" + deviceType + ")not supported to Clone ", e);
        }
        return device;
    }


}
