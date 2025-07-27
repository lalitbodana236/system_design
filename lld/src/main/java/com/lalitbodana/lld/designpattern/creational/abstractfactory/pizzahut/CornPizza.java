package com.lalitbodana.lld.designpattern.creational.abstractfactory.pizzahut;


import com.lalitbodana.lld.designpattern.creational.abstractfactory.Pizza;

public class CornPizza extends Pizza {
    public CornPizza() {
        System.out.println("Creating Corn Pizza at pizzaahut");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Corn Pizza...");
    }
}
