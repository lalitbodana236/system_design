package com.lalitbodana.sde.designpattern.practice.parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime createdOn;
    
    public Ticket() {
        this.createdOn = createdOn;
    }
    
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
    
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
