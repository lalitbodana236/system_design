package com.lalitbodana.lld.decoratordesignpattern.coffeeshop.decorator;

import com.lalitbodana.lld.decoratordesignpattern.coffeeshop.Beverage;

public class Sugar extends AddOnDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 5.0; // Sugar costs an additional 5
    }
}
