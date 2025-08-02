package com.lalitbodana.lld.designpattern.practice.parkinglot.dto;

import java.util.Date;
import java.util.UUID;

public class Ticket {
    private final String ticketId;
    private final String vehicleNumber;
    private final int floorNumber;
    private final String spotId;
    
    private Date entryTime;
    
    private Date exitTime;
    
    public Date getEntryTime() {
        return entryTime;
    }
    
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    
    public Date getExitTime() {
        return exitTime;
    }
    
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
    
    public Ticket(String vehicleNumber, int floorNumber, String spotId) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicleNumber = vehicleNumber;
        this.floorNumber = floorNumber;
        this.spotId = spotId;
        this.entryTime = new Date();
    }
    
    public String getTicketId() {
        return ticketId;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public int getFloorNumber() {
        return floorNumber;
    }
    
    public String getSpotId() {
        return spotId;
    }
}

