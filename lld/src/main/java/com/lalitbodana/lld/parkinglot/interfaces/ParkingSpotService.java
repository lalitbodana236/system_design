package com.lalitbodana.lld.parkinglot.interfaces;

import com.lalitbodana.lld.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.lld.parkinglot.general.parkingSpot.ParkingSpot;

public interface ParkingSpotService {
    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor);
}
