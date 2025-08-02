package com.lalitbodana.lld.designpattern.practice.parkinglot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Vehicle;
import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    
    private static ParkingLot INSTANCE = null;
    
    private final List<ParkingSpot> spots;
    
    private final Map<Vehicle, ParkingSpot> parkedVehicle;
    
    private int capacity = 0;
    
    private ParkingLot(int capacity) {
        this.capacity = capacity;
        this.spots = new ArrayList<>();
        this.parkedVehicle = new HashMap<>();
    }
    
    public static ParkingLot getInstance(int floor, int capacity) {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLot(capacity);
        }
        return INSTANCE;
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : spots) {
            if (parkingSpot.isAvailable() && parkingSpot.canFitVehicle(vehicle)) {
                parkingSpot.parkVehicle(vehicle);
                parkedVehicle.put(vehicle, parkingSpot);
                
                return true;
            }
        }
        
        System.out.println("No available spot for vehicle " + vehicle.getLicensePlate());
        return false;
    }
    
    public void leaveVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkedVehicle.get(vehicle);
        if (spot != null) {
            spot.freeSpot();
            parkedVehicle.remove(vehicle);
        }
    }
    
    public int getAvailableSpots() {
        return (int) this.spots.stream().filter(p -> p.isAvailable()).count();
    }
    
    public void addParkingSpot(ParkingSpot spot) {
        if (spots.size() < capacity) {
            spots.add(spot);
        } else {
            System.out.println("Parking lot is full");
        }
    }
}
