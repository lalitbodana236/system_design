package com.lalitbodana.sde.problem.orderingandratingsystem;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    
    public Order placeOrder(User user, FoodItem foodItem) {
        Order order = new Order(user, foodItem);
        orders.add(order);
        foodItem.getRestaurant().incrementOrderCount();
        return order;
    }
    
    public List<Order> getAllOrders() {
        return orders;
    }
}
