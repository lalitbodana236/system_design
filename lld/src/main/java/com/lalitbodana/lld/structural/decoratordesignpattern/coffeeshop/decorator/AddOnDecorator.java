package com.lalitbodana.lld.structural.decoratordesignpattern.coffeeshop.decorator;

import com.lalitbodana.lld.structural.decoratordesignpattern.coffeeshop.Beverage;

public abstract class AddOnDecorator implements Beverage {
    protected Beverage beverage;

    public AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }
}
