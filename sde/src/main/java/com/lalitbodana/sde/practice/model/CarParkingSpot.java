package com.lalitbodana.sde.practice.model;

import com.lalitbodana.sde.practice.ParkingSpot;

public class CarParkingSpot extends ParkingSpot {
    @Override
    public Boolean canFit(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
    
    @Override
    public void park(ParkingSpot spot) {
        spot.isAvailable = false;
    }
    
    @Override
    public void remove(ParkingSpot spot) {
        spot.isAvailable = true;
    }
}
