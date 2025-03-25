package com.lalitbodana.lld.structural.decoratordesignpattern.pizzafactory;

import com.lalitbodana.lld.structural.decoratordesignpattern.pizzafactory.topping.ExtraCheese;

public class Pizza {

    public static void main(String[] args) {
        BasePizza basePizza = new ExtraCheese(new FarmHouse());
        System.out.println(basePizza.cost());
    }
}
