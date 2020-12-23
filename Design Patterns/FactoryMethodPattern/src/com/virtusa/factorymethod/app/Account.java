package com.virtusa.factorymethod.app;

import java.math.BigDecimal;

public abstract class Account {

    protected static BigDecimal interestRate;
    protected BigDecimal currentAmount;
    protected BigDecimal currentInterest;

    public abstract BigDecimal getInterestRate();

    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }

    public BigDecimal calculateCurrentInterest() {

        try{
            this.currentInterest = currentAmount.divide(new BigDecimal("100.00")).multiply(interestRate);
        }catch (ArithmeticException arithmeticException){
            this.currentInterest  =new BigDecimal("00.00");
        }
        return this.currentInterest;
    }

    public BigDecimal getTotalAmount(){
        return  this.currentAmount.add(this.currentInterest);
    }


}
