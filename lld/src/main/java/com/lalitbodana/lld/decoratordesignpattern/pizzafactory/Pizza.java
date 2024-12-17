package com.lalitbodana.lld.decoratordesignpattern.pizzafactory;

import com.lalitbodana.lld.decoratordesignpattern.pizzafactory.topping.ExtraCheese;

public class Pizza {

    public static void main(String[] args) {
        BasePizza basePizza = new ExtraCheese(new FarmHouse());
        System.out.println(basePizza.cost());
    }
}
