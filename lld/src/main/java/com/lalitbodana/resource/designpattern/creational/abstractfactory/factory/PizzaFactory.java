package com.lalitbodana.resource.designpattern.creational.abstractfactory.factory;


import com.lalitbodana.resource.designpattern.creational.abstractfactory.Pizza;
import com.lalitbodana.resource.designpattern.creational.abstractfactory.PizzaType;

public interface PizzaFactory {
    Pizza getInstance(PizzaType type);
    
}
