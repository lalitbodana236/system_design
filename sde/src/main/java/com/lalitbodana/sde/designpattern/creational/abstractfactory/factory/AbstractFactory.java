package com.lalitbodana.sde.designpattern.creational.abstractfactory.factory;

import com.lalitbodana.sde.designpattern.creational.abstractfactory.dominos.DominosFactory;
import com.lalitbodana.sde.designpattern.creational.abstractfactory.pizzahut.PizzahutFactory;

public class AbstractFactory {
    public static PizzaFactory getFactory(PizzaFactoryEnum brand) {
        return switch (brand) {
            case DOMINOS -> new DominosFactory();
            case PIZZA_HUT -> new PizzahutFactory();
        };
    }
}
