package com.lalitbodana.sde.designpattern.creational.factory;

public class VegPizza extends Pizza {
    public VegPizza() {
        System.out.println("Creating Veg Pizza");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza...");
    }
}
