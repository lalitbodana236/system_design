package com.lalitbodana.lld.parkinglot.parkingstrategy;

import com.lalitbodana.lld.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.lld.parkinglot.exceptions.SpotNotFoundException;
import com.lalitbodana.lld.parkinglot.general.parkingSpot.ParkingSpot;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
