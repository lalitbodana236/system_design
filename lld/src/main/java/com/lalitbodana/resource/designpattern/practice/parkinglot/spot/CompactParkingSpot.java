package com.lalitbodana.resource.designpattern.practice.parkinglot.spot;

import com.lalitbodana.resource.designpattern.practice.parkinglot.dto.Compact;
import com.lalitbodana.resource.designpattern.practice.parkinglot.dto.Vehicle;

public class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot() {
        super();
    }
    
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Compact;
    }
}
