package com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp;

import com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
