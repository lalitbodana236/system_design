package com.lalitbodana.lld.designpattern.practice.parkinglot.dto;

public abstract class Vehicle {
    
    String licensePlate;
    
    String type;
    
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
}
