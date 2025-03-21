package com.lalitbodana.lld.abstractfactorypattern.vehicle;

public class LuxuryFactory implements VehicleFactory {


    @Override
    public Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("V1")) {
            return new LuxuryV1();
        } else if (type.equalsIgnoreCase("V2")) {
            return new LuxuryV2();
        }
        return null;
    }
}
