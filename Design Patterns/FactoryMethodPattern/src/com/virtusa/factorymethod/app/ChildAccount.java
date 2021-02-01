package com.chazool.factorymethod.app;

import java.math.BigDecimal;

public class ChildAccount extends Account{

    @Override
    public BigDecimal getInterestRate() {
        return this.interestRate;
    }


}
