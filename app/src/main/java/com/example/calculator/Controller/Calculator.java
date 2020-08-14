package com.example.calculator.Controller;

public class Calculator {
    private double memory;

    public double getMemory() {
        return memory;
    }

    public void setMemory(double reset) {
        memory = reset;
    }

    public double add(double ...numbers){
        for (double number:numbers) {
            memory+=number;
        }
        //setMemory(memory);
        return memory;
    }
    public double subtract(double ...numbers){
        if(numbers.length>1){
            memory=numbers[0]-numbers[1];
        }else {
            for (double number : numbers) {
                memory -= number;
            }
        }
        setMemory(memory);
        return getMemory();
    }
    public double multiply(double ...numbers){
        if(numbers.length>1){
           memory=numbers[0]*numbers[1];
        }else {
            for (double number : numbers) {
                memory *= number;
            }
        }
        setMemory(memory);
        return getMemory();
    }
    public double division(double ...numbers){
        if(numbers.length>1){
            memory=numbers[0]/numbers[1];
        }else {
            for (double number : numbers) {
               memory /= number;
            }
        }
        setMemory(memory);
        return getMemory();
    }
}