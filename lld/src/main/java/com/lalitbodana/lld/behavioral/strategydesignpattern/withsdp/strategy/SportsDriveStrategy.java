package com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp.strategy;

public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sports Drive Strategy");
    }
}
