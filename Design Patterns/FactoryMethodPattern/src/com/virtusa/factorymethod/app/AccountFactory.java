package com.virtusa.factorymethod.app;

public class AccountFactory {

    public static Account createAccount(AccountType accountType){
        switch (accountType){
            case ChildAccount:
                return new ChildAccount();
            case FixedAccount:
                return new FixedDeposit();
            case SavingAccount:
                return new SavingsAccount();
            case CurrentAccount:
                return new CurrentAccount();
            default:
                return null;
        }
    }
}
