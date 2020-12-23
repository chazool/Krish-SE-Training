package com.virtusa.factorymethod.app;

import java.math.BigDecimal;

public class FixedDeposit extends Account{

    @Override
    public BigDecimal getInterestRate() {
        this.interestRate =new BigDecimal("8.00");
        return this.interestRate;
    }


}
