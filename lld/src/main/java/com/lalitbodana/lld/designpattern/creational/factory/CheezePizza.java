package com.lalitbodana.lld.designpattern.creational.factory;

public class CheezePizza extends Pizza {
    public CheezePizza() {
        System.out.println("Creating Cheese Pizza");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Cheese Pizza...");
    }
}
