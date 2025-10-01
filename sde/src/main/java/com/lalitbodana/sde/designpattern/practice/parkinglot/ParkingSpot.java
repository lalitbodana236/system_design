package com.lalitbodana.sde.designpattern.practice.parkinglot;

public class ParkingSpot {

    private Integer id;
    
    private ParkingType parkingType;
    
    private Boolean isAvailable;
    
    private Integer floor;
    
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public ParkingType getParkingType() {
        return parkingType;
    }
    
    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }
    
    public Boolean getAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
    
    public Integer getFloor() {
        return floor;
    }
    
    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
