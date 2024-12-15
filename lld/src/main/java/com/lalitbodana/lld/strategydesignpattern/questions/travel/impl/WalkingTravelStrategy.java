package com.lalitbodana.lld.strategydesignpattern.questions.travel.impl;

import com.lalitbodana.lld.strategydesignpattern.questions.travel.TravelStrategy;

public class WalkingTravelStrategy implements TravelStrategy {
    @Override
    public void travel(String source, String destination) {
        System.out.println("Traveling on foot from " + source + " to " + destination);
    }
}
