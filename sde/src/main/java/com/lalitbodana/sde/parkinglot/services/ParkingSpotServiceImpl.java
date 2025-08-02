package com.lalitbodana.sde.parkinglot.services;

import com.lalitbodana.sde.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.sde.parkinglot.general.ParkingLot;
import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;
import com.lalitbodana.sde.parkinglot.interfaces.DisplayService;
import com.lalitbodana.sde.parkinglot.interfaces.ParkingSpotService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ParkingSpotServiceImpl implements ParkingSpotService {
    DisplayService displayService = new DisplayServiceImpl();
    List<ParkingSpot> parkingSpotList = new ArrayList<>();

    @Override
    public ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor) {
        try {
            ParkingSpot parkingSpot = (ParkingSpot) parkingSpotEnum.getParkingSpot().getConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotEnum).add(parkingSpot);
            displayService.update(parkingSpotEnum, 1);
            parkingSpotList.add(parkingSpot);
            return parkingSpot;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
}
