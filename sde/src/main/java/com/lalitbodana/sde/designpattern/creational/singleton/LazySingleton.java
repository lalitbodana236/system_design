package com.lalitbodana.sde.designpattern.creational.singleton;

public class LazySingleton {
    
    private static LazySingleton INSTANCE = null;
    
    private LazySingleton() {
        System.out.println("LazySingleton created by: " + Thread.currentThread().getName());
    }
    
    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton(); // ⚠️ Not thread-safe
        }
        return INSTANCE;
    }
}

