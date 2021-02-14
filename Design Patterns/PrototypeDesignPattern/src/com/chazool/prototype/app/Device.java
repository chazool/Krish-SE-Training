package com.chazool.prototype.app;

import java.math.BigDecimal;

public abstract class Device implements  Cloneable{

    private  int deviceCode;
    private String brandName;
    private BigDecimal price;

    public int getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(int deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceCode=" + deviceCode +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                '}';
    }
}
