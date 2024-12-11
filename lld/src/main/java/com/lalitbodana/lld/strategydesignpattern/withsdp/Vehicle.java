package com.lalitbodana.lld.strategydesignpattern.withsdp;

import com.lalitbodana.lld.strategydesignpattern.withsdp.strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    //This is known as Contructor Injection
    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        this.driveStrategy.drive();
    }
}
