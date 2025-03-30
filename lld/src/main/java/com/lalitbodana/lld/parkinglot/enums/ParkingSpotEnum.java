package com.lalitbodana.lld.parkinglot.enums;

import com.lalitbodana.lld.parkinglot.general.parkingSpot.Compact;
import com.lalitbodana.lld.parkinglot.general.parkingSpot.Large;
import com.lalitbodana.lld.parkinglot.general.parkingSpot.Mini;

public enum ParkingSpotEnum {

    COMPACT(Compact.class),
    MINI(Mini.class),
    LARGE(Large.class);

    private final Class parkingSpot;

    ParkingSpotEnum(Class parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Class getParkingSpot() {
        return parkingSpot;
    }
}
