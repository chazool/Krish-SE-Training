package com.chazool.factorymethod.app;

import java.math.BigDecimal;

public class CurrentAccount extends Account{



    @Override
    public BigDecimal getInterestRate() {
        this.interestRate =new BigDecimal("00.00");
        return this.interestRate;
    }

}
