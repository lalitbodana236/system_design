package com.lalitbodana.sde.structural.decoratordesignpattern.coffeeshop;

public class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Coffee";
    }

    @Override
    public double getCost() {
        return 50.0; // Base price of coffee
    }
}
