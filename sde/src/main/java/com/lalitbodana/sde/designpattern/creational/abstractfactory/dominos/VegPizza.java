package com.lalitbodana.sde.designpattern.creational.abstractfactory.dominos;

import com.lalitbodana.sde.designpattern.creational.abstractfactory.Pizza;

public class VegPizza extends Pizza {
    public VegPizza() {
        System.out.println("Creating Veg Pizza at dominos");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Veg Pizza...");
    }
}
