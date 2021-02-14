package com.chazool.memento;

public class Application {

    public static void main(String[] args) {


        CareTaker careTaker = new CareTaker();
        Calculator calculator = new Calculator();
        calculator.addItem(new Item("Watch", 250.00));
        careTaker.save(calculator);
        System.out.println(calculator);
        calculator.addItem(new Item("Button", 20.00));
        careTaker.save(calculator);
        System.out.println(calculator);
        calculator.addItem(new Item("Band", 500.00));
        careTaker.save(calculator);
        System.out.println(calculator);
        calculator.addItem(new Item("Pen", 10.00));
        careTaker.save(calculator);
        System.out.println(calculator);


        careTaker.revert(calculator);
        System.out.println(calculator);

        careTaker.revert(calculator);
        System.out.println(calculator);

        careTaker.revert(calculator);
        System.out.println(calculator);

        careTaker.revert(calculator);
        System.out.println(calculator);

        careTaker.revert(calculator);
        System.out.println(calculator);

        careTaker.revert(calculator);
        System.out.println(calculator);








    }
}
