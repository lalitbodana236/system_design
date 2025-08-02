package com.lalitbodana.lld.designpattern.practice.parkinglot.spot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Compact;
import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Vehicle;

public class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot(int floor) {
        super(floor);
    }
    
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Compact;
    }
}
