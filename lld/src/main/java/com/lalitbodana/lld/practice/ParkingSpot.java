package com.lalitbodana.lld.practice;

import com.lalitbodana.lld.practice.model.Vehicle;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ParkingSpot {
    private static final AtomicInteger x = new AtomicInteger(0);
    public Boolean isAvailable;
    private int id;
    
    public abstract Boolean canFit(Vehicle vehicle);
    
    public abstract void park(ParkingSpot spot);
    
    public abstract void remove(ParkingSpot spot);
}
