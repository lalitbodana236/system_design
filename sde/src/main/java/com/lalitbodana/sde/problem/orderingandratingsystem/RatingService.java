package com.lalitbodana.sde.problem.orderingandratingsystem;

public class RatingService {
    public void rateOrder(Order order, int rating) {
        if (order.isRated()) return;
        
        Restaurant restaurant = order.getRestaurant();
        FoodItem foodItem = order.getFoodItem();
        
        restaurant.addRating(rating);
        foodItem.addRating(rating);
        order.markRated();
    }
}
