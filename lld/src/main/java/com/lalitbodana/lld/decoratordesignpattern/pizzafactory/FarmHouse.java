package com.lalitbodana.lld.decoratordesignpattern.pizzafactory;

public class FarmHouse extends BasePizza {
    @Override
    public int cost() {
        return 100;
    }
}