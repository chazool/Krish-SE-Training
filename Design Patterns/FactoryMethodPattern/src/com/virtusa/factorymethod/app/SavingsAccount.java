package com.virtusa.factorymethod.app;

import java.math.BigDecimal;

public class SavingsAccount extends Account{


    @Override
    public BigDecimal getInterestRate() {
        this.interestRate =new BigDecimal("10.00");
        return this.interestRate;
    }

}
