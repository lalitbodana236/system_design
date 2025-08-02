package com.lalitbodana.sde.parkinglot.general.parkingSpot.parkingspotdecorator;

import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;

public class Wash extends SpotDecorator {

    public Wash(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 20;
    }
}
