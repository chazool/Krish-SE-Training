package com.chazool.builderPattern.controller;

import com.chazool.builderPattern.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Application {

    public static void main(String[] args) {

        String dateFormat = "yyyy-MM-dd";
        String message = null;
        try {
            //Customer
            Customer customer = new Customer();
            customer.setNic("801569818V");
            customer.setFirstName("Amal");
            customer.setLastName("Perera");

            // Reservation Dates
            Date arrivalDate = new SimpleDateFormat(dateFormat).parse("2021-01-10");
            Date departureDate = new SimpleDateFormat(dateFormat).parse("2021-01-15");

            //Meal Plan
            MealPlan mealPlan=new MealPlan();
            mealPlan.setBreakfast(true);
            mealPlan.setLunch(true);
            mealPlan.setDinner(true);

            //Room
            Room room=new Room();
            room.setRoomNo(14);
            room.setSpecial("honeymoon");

            //Rent a Vehicle
            Vehicle vehicle=new Vehicle();
            vehicle.setVehicleType(VehicleType.Car);
            vehicle.setDriver(false);

            //Reservation
            Reservation.Builder reservationBuilder = new Reservation.Builder(customer,arrivalDate,departureDate);

            Reservation reservation=reservationBuilder.room(room).mealPlan(mealPlan).vehicle(vehicle).build();
            System.out.println(reservation);

        } catch (ParseException parseException) {
            message = "Invalid Date , " + parseException.getMessage();
        }
    }


}
