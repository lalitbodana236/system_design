package com.lalitbodana.lld.decoratordesignpattern.pizzafactory.topping;

import com.lalitbodana.lld.decoratordesignpattern.pizzafactory.BasePizza;

public class Mushroom extends ToppingDecorator {
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 20;
    }
}
