package com.lalitbodana.lld.designpattern.creational.singleton;

public class EagerSingleton {
    
    private static final EagerSingleton INSTANCE = new EagerSingleton();
    
    private EagerSingleton() {
        System.out.println("EagerSingleton created by: " + Thread.currentThread().getName());
    }
    
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}

