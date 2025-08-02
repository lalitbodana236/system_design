package com.lalitbodana.resource.problem.orderingandratingsystem;

public class FoodItem {
    private final String itemId;
    private final String name;
    private final double price;
    private final Restaurant restaurant;
    private int totalRating = 0;
    private int ratingCount = 0;
    
    public FoodItem(String itemId, String name, double price, Restaurant restaurant) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }
    
    public void addRating(int rating) {
        totalRating += rating;
        ratingCount++;
    }
    
    public double getAverageRating() {
        return ratingCount == 0 ? 0.0 : (double) totalRating / ratingCount;
    }
    
    public Restaurant getRestaurant() {
        return restaurant;
    }
    
    public String getName() {
        return name;
    }
    
}
