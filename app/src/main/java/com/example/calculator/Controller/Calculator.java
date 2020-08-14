package com.example.calculator.Controller;

public class Calculator {

    public double add(double ...numbers){
        double memory=0;
        for (double number:numbers) {
            memory+=number;
        }
        return memory;
    }
    public double subtract(double ...numbers){
        double memory=0;
        if(numbers.length>1){
            memory=numbers[0]-numbers[1];
        }else {
            for (double number : numbers) {
                memory -= number;
            }
        }
        return memory;
    }
    public double multiply(double ...numbers){
        double memory=0;
        if(numbers.length>1){
           memory=numbers[0]*numbers[1];
        }else {
            for (double number : numbers) {
                memory *= number;
            }
        }
        return memory;
    }
    public double division(double ...numbers){
        double memory=0;
        if(numbers.length>1){
            memory=numbers[0]/numbers[1];
        }else {
            for (double number : numbers) {
               memory /= number;
            }
        }
        return memory;
    }
}