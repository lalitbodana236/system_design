package com.lalitbodana.resource.designpattern.creational.abstractfactory.dominos;

import com.lalitbodana.resource.designpattern.creational.abstractfactory.Pizza;

public class CheezePizza extends Pizza {
    public CheezePizza() {
        System.out.println("Creating Cheese Pizza at dominos");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza...");
    }
}
