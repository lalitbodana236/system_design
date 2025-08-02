package com.lalitbodana.resource.designpattern.creational.abstractfactory.pizzahut;

import com.lalitbodana.resource.designpattern.creational.abstractfactory.Pizza;
import com.lalitbodana.resource.designpattern.creational.abstractfactory.PizzaType;
import com.lalitbodana.resource.designpattern.creational.abstractfactory.factory.PizzaFactory;


public class PizzahutFactory implements PizzaFactory {
    
    @Override
    public Pizza getInstance(PizzaType type) {
        return switch (type) {
            case VEG_PIZZA -> new VegPizza();
            case CORN_PIZZA -> new CornPizza();
            case CHEESE_PIZZA -> new CheezePizza();
        };
    }
}
