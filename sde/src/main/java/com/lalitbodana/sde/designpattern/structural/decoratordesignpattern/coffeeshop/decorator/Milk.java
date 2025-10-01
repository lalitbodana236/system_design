package com.lalitbodana.sde.designpattern.structural.decoratordesignpattern.coffeeshop.decorator;

import com.lalitbodana.sde.designpattern.structural.decoratordesignpattern.coffeeshop.Beverage;

public class Milk extends AddOnDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 10.0; // Milk costs an additional 10
    }
}
