package com.lalitbodana.lld.designpattern.practice.parkinglot.entity;

public abstract class Vehicle {
    
    String licensePlate;
    
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
}
