package com.lalitbodana.lld.strategydesignpattern.questions.travel;

public class TravelPlanner {

    private TravelStrategy travelStrategy;

    public TravelPlanner(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void planTravel(String source, String destination) {
        travelStrategy.travel(source, destination);
    }
}
