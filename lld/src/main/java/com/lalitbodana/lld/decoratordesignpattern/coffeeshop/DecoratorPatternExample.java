package com.lalitbodana.lld.decoratordesignpattern.coffeeshop;

import com.lalitbodana.lld.decoratordesignpattern.coffeeshop.decorator.Milk;
import com.lalitbodana.lld.decoratordesignpattern.coffeeshop.decorator.Sugar;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Base coffee
        Beverage coffee = new Coffee();
        System.out.println(coffee.getDescription() + " costs " + coffee.getCost());

        // Coffee with milk
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription() + " costs " + coffee.getCost());

        // Coffee with milk and sugar
        coffee = new Sugar(coffee);
        System.out.println(coffee.getDescription() + " costs " + coffee.getCost());
    }
}
