package com.lalitbodana.lld.designpattern.creational.singleton;

public enum EnumSingleton {
    INSTANCE;
    
    EnumSingleton() {
        System.out.println("EnumSingleton created by: " + Thread.currentThread().getName());
    }
    
    public void doSomething() {
        System.out.println("EnumSingleton action");
    }
}

