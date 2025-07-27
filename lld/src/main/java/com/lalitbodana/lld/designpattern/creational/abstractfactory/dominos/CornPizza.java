package com.lalitbodana.lld.designpattern.creational.abstractfactory.dominos;

import com.lalitbodana.lld.designpattern.creational.abstractfactory.Pizza;

public class CornPizza extends Pizza {
    public CornPizza() {
        System.out.println("Creating Corn Pizza at dominos");
    }
    
    @Override
    public void prepare() {
        System.out.println("Preparing Corn Pizza...");
    }
}
