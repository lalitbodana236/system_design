package com.lalitbodana.lld.strategydesignpattern.withsdp;

import com.lalitbodana.lld.strategydesignpattern.withsdp.strategy.SportsDriveStrategy;

public class SportVehicle extends Vehicle {
    public SportVehicle() {
        super(new SportsDriveStrategy());
    }
}
