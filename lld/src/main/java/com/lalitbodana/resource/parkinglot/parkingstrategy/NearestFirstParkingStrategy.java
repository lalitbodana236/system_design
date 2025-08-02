package com.lalitbodana.resource.parkinglot.parkingstrategy;

import com.lalitbodana.resource.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.resource.parkinglot.exceptions.SpotNotFoundException;
import com.lalitbodana.resource.parkinglot.general.ParkingLot;
import com.lalitbodana.resource.parkinglot.general.parkingSpot.ParkingSpot;

import java.util.List;

public class NearestFirstParkingStrategy implements Strategy {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {

        List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if (parkingSpots.size() == 0) {
            throw new SpotNotFoundException("Spot not found in nearest first strategy");
        }
        return parkingSpots.get(0);
    }
}
