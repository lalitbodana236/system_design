package com.lalitbodana.lld.designpattern.creational.singleton;

public class SynchronizedSingleton {
    
    private static SynchronizedSingleton INSTANCE = null;
    
    private SynchronizedSingleton() {
        System.out.println("SynchronizedSingleton created by: " + Thread.currentThread().getName());
    }
    
    public static synchronized SynchronizedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SynchronizedSingleton();
        }
        return INSTANCE;
    }
}

