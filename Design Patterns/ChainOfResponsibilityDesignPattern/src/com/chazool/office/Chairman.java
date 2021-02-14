package com.chazool.office;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Chairman extends EmployeeHandler {
    @Override
    public Security unlockDoor(Security security) {

        Set<Door> lockedDoor = security.getLockedDoor();
        if (lockedDoor.isEmpty() == false && security.getEmployeeRole() == EmployeeRole.chairman) {
            for (Door door : lockedDoor) {
                if (door.getPriorityId() == 1) {
                    security.getUnlockedDoor().add(door);
                }
            }
        }

        return successor.unlockDoor(security);
    }
}

