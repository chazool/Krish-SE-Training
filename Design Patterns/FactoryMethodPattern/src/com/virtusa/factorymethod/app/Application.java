package com.virtusa.factorymethod.app;

import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) {

        //Account Type Fix Deposit
        Account fixDeposit = AccountFactory.createAccount(AccountType.FixedAccount);
        BigDecimal fixDepositInterestRate = fixDeposit.getInterestRate();
        fixDeposit.setCurrentAmount(new BigDecimal("500.00"));
        BigDecimal fixDepositCurrentInterest=fixDeposit.calculateCurrentInterest();
        BigDecimal fixDepositTotalAmount=  fixDeposit.getTotalAmount();


        System.out.println("FixDepositInterestRate : "+ fixDepositInterestRate);
        System.out.println("fixDepositCurrentInterest : "+ fixDepositCurrentInterest);
        System.out.println("fixDepositTotalAmount : "+ fixDepositTotalAmount);


    }
}
