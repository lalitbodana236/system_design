package com.lalitbodana.lld.designpattern.practice.parkinglot.spot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.dto.Mini;
import com.lalitbodana.lld.designpattern.practice.parkinglot.dto.Vehicle;

public class MiniParkingSpot extends ParkingSpot {
    public MiniParkingSpot() {
        super();
    }
    
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Mini;
    }
}
