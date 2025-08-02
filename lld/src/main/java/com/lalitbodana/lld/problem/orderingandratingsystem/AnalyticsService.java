package com.lalitbodana.lld.problem.orderingandratingsystem;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnalyticsService {
    private final RestaurantService restaurantService;
    
    public AnalyticsService(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    
    public List<Restaurant> getTopRestaurantsByAvgRating(int k) {
        return restaurantService.getAllRestaurants().stream()
                       .sorted(Comparator.comparingDouble(Restaurant::getAverageRating).reversed())
                       .limit(k)
                       .collect(Collectors.toList());
    }
    
    public List<Restaurant> getTopRestaurantsByPopularItems(int k) {
        return restaurantService.getAllRestaurants().stream()
                       .sorted(Comparator.comparingInt(Restaurant::getOrderCount).reversed())
                       .limit(k)
                       .collect(Collectors.toList());
    }
    
    public List<Restaurant> getTopRestaurantsByHighestRatedItem(int k) {
        return restaurantService.getAllRestaurants().stream()
                       .sorted((r1, r2) -> Double.compare(
                               Optional.ofNullable(r2.getHighestRatedFoodItem()).map(FoodItem::getAverageRating).orElse(0.0),
                               Optional.ofNullable(r1.getHighestRatedFoodItem()).map(FoodItem::getAverageRating).orElse(0.0)
                       ))
                       .limit(k)
                       .collect(Collectors.toList());
    }
}
