package com.chazool.office;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Security {

    private Set<Door> lockedDoor;
    private Set<Door> unlockedDoor;
    private EmployeeRole employeeRole;

    public Security(Set<Door> doors) {
        this.lockedDoor = doors;
        this.unlockedDoor =new HashSet<>();
    }

    public Set<Door> getLockedDoor() {
        return lockedDoor;
    }

    public void setLockedDoor(Set<Door> lockedDoor) {
        this.lockedDoor = lockedDoor;
    }

    public Set<Door> getUnlockedDoor() {
        return unlockedDoor;
    }

    public void setUnlockedDoor(Set<Door> unlockedDoor) {
        this.unlockedDoor = unlockedDoor;
    }

    public EmployeeRole getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRole = employeeRole;
    }
}
