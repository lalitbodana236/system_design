package com.lalitbodana.lld.factorypattern.shape;

public class FactoryMain {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getFactory("circle");
        shape.draw();
    }
}
