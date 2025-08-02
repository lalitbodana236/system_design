package com.lalitbodana.resource.problem.orderingandratingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {
    private final Map<String, Restaurant> restaurants = new HashMap<>();
    
    public void addRestaurant(Restaurant r) {
        restaurants.put(r.getId(), r);
    }
    
    public Restaurant getRestaurant(String id) {
        return restaurants.get(id);
    }
    
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants.values());
    }
}
