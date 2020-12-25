package com.virtusa.office;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Manager extends EmployeeHandler {
    @Override
    public Security unlockDoor(Security security) {

        Set<Door> lockedDoor = security.getLockedDoor();
        if (lockedDoor.isEmpty() == false  && (security.getEmployeeRole() == EmployeeRole.ceo ||
                security.getEmployeeRole() == EmployeeRole.chairman || security.getEmployeeRole() == EmployeeRole.manager)) {

            for (Door door : lockedDoor) {
                if (door.getPriorityId() == 3) {
                    security.getUnlockedDoor().add(door);
                }
            }
        }
        return successor.unlockDoor(security);
    }

}
