package com.lalitbodana.sde.parkinglot.parkingstrategy;

import com.lalitbodana.sde.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.sde.parkinglot.exceptions.SpotNotFoundException;
import com.lalitbodana.sde.parkinglot.general.ParkingLot;
import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;

import java.util.List;

public class FarthestFirstParkingStrategy implements Strategy {
    @Override
    public ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException {
        List<ParkingSpot> parkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if (parkingSpots.size() == 0) {
            throw new SpotNotFoundException("Spot not found in nearest farthest strategy");
        }
        return parkingSpots.get(parkingSpots.size() - 1);
    }
}
