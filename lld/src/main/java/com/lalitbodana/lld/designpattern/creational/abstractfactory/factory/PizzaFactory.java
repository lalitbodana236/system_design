package com.lalitbodana.lld.designpattern.creational.abstractfactory.factory;


import com.lalitbodana.lld.designpattern.creational.abstractfactory.Pizza;
import com.lalitbodana.lld.designpattern.creational.abstractfactory.PizzaType;

public interface PizzaFactory {
    Pizza getInstance(PizzaType type);
    
}
