package com.lalitbodana.lld.parkinglot.general.parkingSpot.parkingspotdecorator;

import com.lalitbodana.lld.parkinglot.general.parkingSpot.ParkingSpot;

public abstract class SpotDecorator extends ParkingSpot {
    protected ParkingSpot parkingSpot;

    public SpotDecorator(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
