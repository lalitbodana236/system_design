package com.lalitbodana.resource.problem.orderingandratingsystem;

public class Order {
    private static int idCounter = 1;
    private final String orderId;
    private final User user;
    private final FoodItem foodItem;
    private boolean rated = false;
    
    public Order(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
        this.orderId = "ORD-" + idCounter++;
    }
    
    
    public FoodItem getFoodItem() {
        return foodItem;
    }
    
    public Restaurant getRestaurant() {
        return foodItem.getRestaurant();
    }
    
    public boolean isRated() {
        return rated;
    }
    
    public void markRated() {
        this.rated = true;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
}
