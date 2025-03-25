package com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp;

import com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp.strategy.SportsDriveStrategy;

public class SportVehicle extends Vehicle {
    public SportVehicle() {
        super(new SportsDriveStrategy());
    }
}
