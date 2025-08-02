package com.lalitbodana.lld.problem.orderingandratingsystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private final String id;
    private final String name;
    private final List<FoodItem> menu;
    private int totalRating = 0;
    private int ratingCount = 0;
    private int orderCount = 0;
    
    public Restaurant(String id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }
    
    public void addFoodItem(FoodItem item) {
        menu.add(item);
    }
    
    public List<FoodItem> getMenu() {
        return menu;
    }
    
    public void addRating(int rating) {
        totalRating += rating;
        ratingCount++;
    }
    
    public double getAverageRating() {
        return ratingCount == 0 ? 0.0 : (double) totalRating / ratingCount;
    }
    
    public void incrementOrderCount() {
        orderCount++;
    }
    
    public int getOrderCount() {
        return orderCount;
    }
    
    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }
    
    public FoodItem getHighestRatedFoodItem() {
        return menu.stream()
                       .max(Comparator.comparingDouble(FoodItem::getAverageRating))
                       .orElse(null);
    }
    
}
