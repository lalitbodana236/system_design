package com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp;

import com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }

}
