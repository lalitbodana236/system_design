package com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new GoodsVehicle();
        vehicle.drive();

        vehicle = new OffRoadVehicle();
        vehicle.drive();

        vehicle = new GoodsVehicle();
        vehicle.drive();
    }
}
