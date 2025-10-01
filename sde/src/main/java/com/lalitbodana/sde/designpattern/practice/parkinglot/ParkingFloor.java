package com.lalitbodana.sde.designpattern.practice.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingFloor {
    
    private Integer floorId;
    
    private Map<ParkingType, List<ParkingSpot>> occupiedSpots;
    private Map<ParkingType, List<ParkingSpot>> vacantSpots;
    
    public ParkingFloor(Map<ParkingType, List<ParkingSpot>> occupiedSpots, Map<ParkingType, List<ParkingSpot>> vacantSpots) {
        this.occupiedSpots = occupiedSpots;
        this.vacantSpots = vacantSpots;
        
        for(ParkingType parkingType : ParkingType.values()){
            this.occupiedSpots.put(parkingType,new ArrayList<>());
            this.vacantSpots.put(parkingType,new ArrayList<>());
        }
    }
    
    public void addParkingSpot(ParkingSpot spot){
        List<ParkingSpot> parkingSpots = getVacantSpots().get(spot.getParkingType());
        
        if(Objects.isNull(parkingSpots)){
            parkingSpots=new ArrayList<>();
        }
        
        parkingSpots.add(spot);
        this.vacantSpots.put(spot.getParkingType(),parkingSpots);
    }
    
    public Integer getFloorId() {
        return floorId;
    }
    
    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }
    
    public Map<ParkingType, List<ParkingSpot>> getOccupiedSpots() {
        return occupiedSpots;
    }
    
    public void setOccupiedSpots(Map<ParkingType, List<ParkingSpot>> occupiedSpots) {
        this.occupiedSpots = occupiedSpots;
    }
    
    public Map<ParkingType, List<ParkingSpot>> getVacantSpots() {
        return vacantSpots;
    }
    
    public void setVacantSpots(Map<ParkingType, List<ParkingSpot>> vacantSpots) {
        this.vacantSpots = vacantSpots;
    }
}
