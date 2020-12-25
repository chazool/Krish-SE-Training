package com.virtusa.memento;

import java.util.SortedMap;
import java.util.Stack;

public class CareTaker {

    Stack<Calculator.CalculatorMemento> history = new Stack<>();


    public void  save(Calculator calculator){
        history.push(calculator.save());
    }


    public  void  revert(Calculator calculator){

        if (!history.isEmpty())
            calculator.revert(history.pop());
        else
            System.out.println("Cannot Undo.!");

    }



}
