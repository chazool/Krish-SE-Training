package com.chazool.office;

import java.math.BigDecimal;
import java.util.List;

public abstract class EmployeeHandler {

    protected EmployeeHandler successor;
    protected int employeeRole;

    public abstract  Security unlockDoor(Security security);

    public void setSuccessor(EmployeeHandler successor) {
        this.successor = successor;
    }

    public void setEmployeeRole(int employeeRole) {
        this.employeeRole = employeeRole;
    }
}
