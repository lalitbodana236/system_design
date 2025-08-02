package com.lalitbodana.sde.designpattern.creational.factory;

public class CornPizza extends Pizza {
    public CornPizza() {
        System.out.println("Creating Corn Pizza");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Corn Pizza...");
    }
}
