package com.lalitbodana.lld.creational.abstractfactorypattern.vehicle;

public class Main {
    public static void main(String[] args) {
        // Get an Ordinary Factory
        VehicleFactory ordinaryFactory = FactoryProducer.getFactory("ORDINARY");
        Vehicle ordinaryV1 = ordinaryFactory.getVehicle("V1");
        ordinaryV1.average(); // Output: OrdinaryV1: 15 km/l

        Vehicle ordinaryV2 = ordinaryFactory.getVehicle("V2");
        ordinaryV2.average(); // Output: OrdinaryV2: 18 km/l

        // Get a Luxury Factory
        VehicleFactory luxuryFactory = FactoryProducer.getFactory("LUXURY");
        Vehicle luxuryV1 = luxuryFactory.getVehicle("V1");
        luxuryV1.average(); // Output: LuxuryV1: 10 km/l

        Vehicle luxuryV2 = luxuryFactory.getVehicle("V2");
        luxuryV2.average(); // Output: LuxuryV2: 12 km/l
    }
}
