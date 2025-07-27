package com.lalitbodana.lld.designpattern.creational.abstractfactory.dominos;

import com.lalitbodana.lld.designpattern.creational.abstractfactory.Pizza;
import com.lalitbodana.lld.designpattern.creational.abstractfactory.PizzaType;
import com.lalitbodana.lld.designpattern.creational.abstractfactory.factory.PizzaFactory;


public class DominosFactory implements PizzaFactory {
    
    @Override
    public Pizza getInstance(PizzaType type) {
        return switch (type) {
            case VEG_PIZZA -> new VegPizza();
            case CORN_PIZZA -> new CornPizza();
            case CHEESE_PIZZA -> new CheezePizza();
        };
    }
}
