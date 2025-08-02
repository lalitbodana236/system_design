package com.lalitbodana.sde.designpattern.creational.abstractfactory.pizzahut;


import com.lalitbodana.sde.designpattern.creational.abstractfactory.Pizza;

public class CheezePizza extends Pizza {
    public CheezePizza() {
        System.out.println("Creating Cheese Pizza at pizzaahut");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza...");
    }
}
