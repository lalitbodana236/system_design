package com.lalitbodana.sde.problem.orderingandratingsystem;

public class RestaurantSystemMain {
    public static void main(String[] args) {
        // Setup
        User user1 = new User("U1", "Alice");
        
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();
        RatingService ratingService = new RatingService();
        AnalyticsService analyticsService = new AnalyticsService(restaurantService);
        
        Restaurant r1 = new Restaurant("R1", "Spice Garden");
        FoodItem f1 = new FoodItem("F1", "Paneer Tikka", 200.0, r1);
        FoodItem f2 = new FoodItem("F2", "Veg Biryani", 180.0, r1);
        r1.addFoodItem(f1);
        r1.addFoodItem(f2);
        
        Restaurant r2 = new Restaurant("R2", "Pizza Hub");
        FoodItem f3 = new FoodItem("F3", "Margherita", 250.0, r2);
        r2.addFoodItem(f3);
        
        restaurantService.addRestaurant(r1);
        restaurantService.addRestaurant(r2);
        
        // Orders
        Order o1 = orderService.placeOrder(user1, f1);
        Order o2 = orderService.placeOrder(user1, f2);
        Order o3 = orderService.placeOrder(user1, f3);
        
        // Ratings
        ratingService.rateOrder(o1, 5);
        ratingService.rateOrder(o2, 4);
        ratingService.rateOrder(o3, 3);
        
        // Queries
        System.out.println("\nTop by Avg Rating:");
        analyticsService.getTopRestaurantsByAvgRating(2)
                .forEach(r -> System.out.println(r.getName() + " -> " + r.getAverageRating()));
        
        System.out.println("\nTop by Order Count:");
        analyticsService.getTopRestaurantsByPopularItems(2)
                .forEach(r -> System.out.println(r.getName() + " -> " + r.getOrderCount()));
        
        System.out.println("\nTop by Highest Rated Item:");
        analyticsService.getTopRestaurantsByHighestRatedItem(2)
                .forEach(r -> {
                    FoodItem topItem = r.getHighestRatedFoodItem();
                    String topItemName = topItem != null ? topItem.getName() : "None";
                    double rating = topItem != null ? topItem.getAverageRating() : 0.0;
                    System.out.println(r.getName() + " -> " + topItemName + " (" + rating + ")");
                });
    }
}

