package com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.impl;

import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.TravelStrategy;

public class BicycleTravelStrategy implements TravelStrategy {
    @Override
    public void travel(String source, String destination) {
        System.out.println("Traveling by bicycle from " + source + " to " + destination);
    }
}
