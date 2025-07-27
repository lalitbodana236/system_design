package com.lalitbodana.lld.designpattern.creational.singleton;

public class BillPughSingleton {
    
    private BillPughSingleton() {
        System.out.println("BillPughSingleton created by: " + Thread.currentThread().getName());
    }
    
    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
    
    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
}

