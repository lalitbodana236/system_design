package com.lalitbodana.lld.structural.decoratordesignpattern.pizzafactory.topping;

import com.lalitbodana.lld.structural.decoratordesignpattern.pizzafactory.BasePizza;

public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza; //has-a

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 50;
    }
}
