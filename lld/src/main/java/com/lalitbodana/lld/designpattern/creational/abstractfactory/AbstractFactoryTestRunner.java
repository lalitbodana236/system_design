package com.lalitbodana.lld.designpattern.creational.abstractfactory;

import com.lalitbodana.lld.designpattern.creational.abstractfactory.factory.AbstractFactory;
import com.lalitbodana.lld.designpattern.creational.abstractfactory.factory.PizzaFactory;
import com.lalitbodana.lld.designpattern.creational.abstractfactory.factory.PizzaFactoryEnum;

public class AbstractFactoryTestRunner {
    public static void main(String[] args) {
        PizzaFactory dominos = AbstractFactory.getFactory(PizzaFactoryEnum.DOMINOS);
        PizzaFactory pizzaHut = AbstractFactory.getFactory(PizzaFactoryEnum.PIZZA_HUT);
        
        Pizza d1 = dominos.getInstance(PizzaType.CHEESE_PIZZA);
        d1.prepare();
        
        Pizza d2 = dominos.getInstance(PizzaType.CORN_PIZZA);
        d2.prepare();
        
        Pizza p1 = pizzaHut.getInstance(PizzaType.VEG_PIZZA);
        p1.prepare();
    }
}
