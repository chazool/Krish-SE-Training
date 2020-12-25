package com.virtusa.office;

import java.util.List;

public class Employee  extends EmployeeHandler{

    @Override
    public Security unlockDoor(Security security) {

        return successor.unlockDoor(security);
    }
}
