package com.lalitbodana.lld.designpattern.practice.parkinglot.spot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Vehicle;

public abstract class ParkingSpot {
    int floor = 0;
    int id;
    
    private boolean isAvailable;
    
    public ParkingSpot(int id) {
        this.id = id;
        this.isAvailable = true;
        // this.floor = floor;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public abstract boolean canFitVehicle(Vehicle vehicle);
    
    public void parkVehicle(Vehicle vehicle) {
        isAvailable = false;
        System.out.println("Vehicle is parked " + vehicle.getLicensePlate() + " at " + this.id);
    }
    
    public void freeSpot() {
        isAvailable = true;
        System.out.println("Spot " + id + " is now free");
    }
    
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
