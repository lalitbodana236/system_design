package com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.impl;

import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.TravelStrategy;

public class CarTravelStrategy implements TravelStrategy {
    @Override
    public void travel(String source, String destination) {
        System.out.println("Traveling by car from " + source + " to " + destination);
    }
}
