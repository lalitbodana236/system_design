package com.lalitbodana.sde.designpattern.creational.factory;

public class FactoryTestRunner {
    public static void main(String[] args) {
        Pizza cheesePizza = PizzaFactory.getInstance(PizzaType.CHEESE_PIZZA);
        cheesePizza.prepare();
        
        Pizza cornPizza = PizzaFactory.getInstance(PizzaType.CORN_PIZZA);
        cornPizza.prepare();
        
        Pizza vegPizza = PizzaFactory.getInstance(PizzaType.VEG_PIZZA);
        vegPizza.prepare();
    }
}
