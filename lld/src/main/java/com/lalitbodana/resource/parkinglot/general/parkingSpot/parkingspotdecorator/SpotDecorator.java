package com.lalitbodana.resource.parkinglot.general.parkingSpot.parkingspotdecorator;

import com.lalitbodana.resource.parkinglot.general.parkingSpot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
