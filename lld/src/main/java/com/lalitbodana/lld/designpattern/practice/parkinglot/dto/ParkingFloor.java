package com.lalitbodana.lld.designpattern.practice.parkinglot.dto;

import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    public List<ParkingSpot> spots;
    public int capacity;
    
    
    public ParkingFloor(int floorNumber, int capacity) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>(capacity);
        this.capacity = capacity;
    }
    
    public int getFloorNumber() {
        return floorNumber;
    }
    
    public void addSpot(ParkingSpot spot) {
        if (spots.size() < this.capacity)
            spots.add(spot);
    }
    
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null;
    }
    
    public Map<String, SpotCount> getSpotStatsByType() {
        Map<String, SpotCount> map = new HashMap<>();
        for (ParkingSpot spot : spots) {
            String type = spot.getClass().getSimpleName(); // e.g., MiniSpot, CompactSpot
            SpotCount count = map.getOrDefault(type, new SpotCount());
            count.total++;
            if (spot.isAvailable()) {
                count.available++;
            }
            map.put(type, count);
        }
        return map;
    }
    
    // Helper class
    public static class SpotCount {
        public int total = 0;
        public int available = 0;
    }
}

