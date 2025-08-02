package com.lalitbodana.sde.parkinglot.general.parkingSpot.parkingspotdecorator;

import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;

public class Electric extends SpotDecorator {
    public Electric(ParkingSpot parkingSpot) {
        super(parkingSpot);
    }

    @Override
    public int cost(int parkingHours) {
        return parkingSpot.cost(parkingHours) + 50;
    }
}
