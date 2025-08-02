package com.lalitbodana.resource.designpattern.creational.singleton;

public class DoubleCheckedLockingSingleton {
    
    private static volatile DoubleCheckedLockingSingleton INSTANCE = null;
    
    private DoubleCheckedLockingSingleton() {
        System.out.println("DoubleCheckedLockingSingleton created by: " + Thread.currentThread().getName());
    }
    
    public static DoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }
}

