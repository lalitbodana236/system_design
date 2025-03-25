package com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel;

import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.impl.BicycleTravelStrategy;
import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.impl.CarTravelStrategy;
import com.lalitbodana.lld.behavioral.strategydesignpattern.questions.travel.impl.WalkingTravelStrategy;

public class Client {

    public static void main(String[] args) {
        TravelPlanner travelPlanner = new TravelPlanner(new CarTravelStrategy());

        // Plan travel by car
        travelPlanner.planTravel("Home", "Office");

        // Change strategy to bicycle
        travelPlanner.setTravelStrategy(new BicycleTravelStrategy());
        // Plan travel by bicycle
        travelPlanner.planTravel("Office", "Park");

        // Change strategy to walking
        travelPlanner.setTravelStrategy(new WalkingTravelStrategy());
        // Plan travel by walking
        travelPlanner.planTravel("Park", "Restaurant");
    }
}
