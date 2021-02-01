package com.chazool.builderPattern.entity;

import java.util.Date;

public class Reservation {

    private Customer customer;
    private MealPlan mealPlan;
    private Room room;
    private Vehicle vehicle;
    private Date arrivalDate;
    private Date departureDate;

    public Reservation(Builder builder) {
        this.customer = builder.customer;
        this.mealPlan = builder.mealPlan;
        this.room = builder.room;
        this.vehicle = builder.vehicle;
        this.arrivalDate = builder.arrivalDate;
        this.departureDate = builder.departureDate;
    }

    public static class Builder {
        private Customer customer;
        private MealPlan mealPlan;
        private Room room;
        private Vehicle vehicle;
        private Date arrivalDate;
        private Date departureDate;

        public Reservation build() {
            return new Reservation(this);
        }

        public Builder(Customer customer, Date arrivalDate, Date departureDate) {
            this.customer = customer;
            this.arrivalDate = arrivalDate;
            this.departureDate = departureDate;
        }

        public Builder room(Room room) {
            this.room = room;
            return this;
        }

        public Builder mealPlan(MealPlan mealPlan) {
            this.mealPlan = mealPlan;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }


    }

    @Override
    public String toString() {
        return "Reservation{ " + "\n" +
                "customer=" + customer + "\n" +
                ", mealPlan=" + mealPlan + "\n" +
                ", room=" + room + "\n" +
                ", vehicle=" + vehicle + "\n" +
                ", arrivalDate=" + arrivalDate + "\n" +
                ", departureDate=" + departureDate + "\n" +
                '}';
    }
}
