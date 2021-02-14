package com.chazool.office;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Officer extends EmployeeHandler {
    @Override
    public Security unlockDoor(Security security) {

        Set<Door> lockedDoor = security.getLockedDoor();
        if (lockedDoor.isEmpty() == false && (security.getEmployeeRole() == EmployeeRole.ceo ||
                security.getEmployeeRole() == EmployeeRole.chairman || security.getEmployeeRole() == EmployeeRole.manager ||
                security.getEmployeeRole() == EmployeeRole.officer)) {

            for (Door door : lockedDoor) {
                if (door.getPriorityId() == 4) {
                    security.getUnlockedDoor().add(door);
                }
            }

        }
        return security;

    }
}
