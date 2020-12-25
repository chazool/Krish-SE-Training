package com.virtusa.memento;

import java.util.ArrayList;

public class Calculator {

    ArrayList<Item> items = new ArrayList<>();
    double total;


    public void addItem(Item item) {
        total = total + item.getPrice();
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return (ArrayList<Item>) items.clone();
    }

    public CalculatorMemento save() {
        return new CalculatorMemento(getItems());
    }

    public void revert(CalculatorMemento calculatorMemento) {
        total = 0.00;
        for (Item item : calculatorMemento.items) {
            total = total + item.getPrice();
        }
        items = calculatorMemento.getItems();
    }

    static class CalculatorMemento {
        ArrayList<Item> items;
        double total;

        public CalculatorMemento(ArrayList<Item> bills) {

            this.items = bills;
        }

        public ArrayList<Item> getItems() {
            return items;
        }
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
