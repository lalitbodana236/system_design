package com.lalitbodana.lld.practice.model;


import java.util.concurrent.atomic.AtomicInteger;

public abstract class Vehicle {
    private static final AtomicInteger x = new AtomicInteger(0);
    private final int id;
    private final String regNo;
    
    public Vehicle(String regNo) {
        id = x.incrementAndGet();
        this.regNo = regNo;
    }
}
