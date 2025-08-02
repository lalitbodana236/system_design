package com.lalitbodana.sde.designpattern.creational.factory;

public class PizzaFactory {
    
    public static Pizza getInstance(PizzaType type) {
        return switch (type) {
            case VEG_PIZZA -> new VegPizza();
            case CORN_PIZZA -> new CornPizza();
            case CHEESE_PIZZA -> new CheezePizza();
        };
    }
}
