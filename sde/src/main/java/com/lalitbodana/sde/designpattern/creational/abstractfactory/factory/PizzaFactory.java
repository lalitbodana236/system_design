package com.lalitbodana.sde.designpattern.creational.abstractfactory.factory;


import com.lalitbodana.sde.designpattern.creational.abstractfactory.Pizza;
import com.lalitbodana.sde.designpattern.creational.abstractfactory.PizzaType;

public interface PizzaFactory {
    Pizza getInstance(PizzaType type);
    
}
