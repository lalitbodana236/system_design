package com.lalitbodana.lld.creational.factorypattern.shape;

public class ShapeFactory {

    public Shape getFactory(String input) {
        switch (input) {
            case "circle":
                return new Circle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
