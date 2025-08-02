package com.lalitbodana.resource.designpattern.practice.parkinglot.spot;

import com.lalitbodana.resource.designpattern.practice.parkinglot.dto.Vehicle;

import java.util.UUID;

public abstract class ParkingSpot {
    String id;
    
    private boolean isAvailable;
    
    public ParkingSpot() {
        this.id = UUID.randomUUID().toString();
        this.isAvailable = true;
    }
    
    
    public String getId() {
        return id;
    }
    
    public abstract boolean canFitVehicle(Vehicle vehicle);
    
    public void parkVehicle(Vehicle vehicle) {
        isAvailable = false;
        System.out.println("Vehicle is parked " + vehicle.getLicensePlate() + " at " + this.getId());
    }
    
    public void freeSpot() {
        isAvailable = true;
        
        System.out.println("Spot " + id + " is now free");
    }
    
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
