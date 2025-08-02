package com.lalitbodana.lld.designpattern.practice.parkinglot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Mini;
import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Vehicle;
import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.ParkingSpot;

public class MiniParkingSpot extends ParkingSpot {
    public MiniParkingSpot(int floor) {
        super(floor);
    }
    
    @Override
    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle instanceof Mini;
    }
}
