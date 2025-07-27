package com.lalitbodana.lld.designpattern.creational.abstractfactory.pizzahut;


import com.lalitbodana.lld.designpattern.creational.abstractfactory.Pizza;

public class VegPizza extends Pizza {
    public VegPizza() {
        System.out.println("Creating Veg Pizza at pizzaahut");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza...");
    }
}
