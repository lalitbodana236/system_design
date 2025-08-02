package com.lalitbodana.sde.parkinglot.general.parkingSpot.parkingspotdecorator;

import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
