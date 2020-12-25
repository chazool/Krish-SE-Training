package com.virtusa.office;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Chairman chairman = new Chairman();
        CEO ceo = new CEO();
        Manager manager = new Manager();
        Officer officer = new Officer();


        employee.setSuccessor(chairman);
        chairman.setSuccessor(ceo);
        ceo.setSuccessor(manager);
        manager.setSuccessor(officer);

        // Door and - Doors  List
        Set<Door> doors = new HashSet<>();

        Door door = new Door();
        door.setId(1);
        door.setPriorityId(1);

        Door door1 = new Door();
        door1.setId(2);
        door1.setPriorityId(1);


        Door door2 = new Door();
        door2.setId(3);
        door2.setPriorityId(1);

        Door door3 = new Door();
        door3.setId(4);
        door3.setPriorityId(2);

        doors.add(door);
        doors.add(door1);
        doors.add(door2);
        doors.add(door3);

        // Security Object
        Security security = new Security(doors);
        security.setEmployeeRole(EmployeeRole.ceo);

        // Unlocked Doors
        security = employee.unlockDoor(security);

        for (Door d : security.getUnlockedDoor()) {
            System.out.println(d);
        }


    }
}
