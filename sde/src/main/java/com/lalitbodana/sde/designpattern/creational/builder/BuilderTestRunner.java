package com.lalitbodana.sde.designpattern.creational.builder;

public class BuilderTestRunner {
    public static void main(String[] args) {
        
        QueryBuilder builder = new QueryBuilder();
        Query query = builder
                              .select(new String[]{"name", "age"}, "users")
                              .where("name", "John")
                              .build();
        System.out.println(query.getQuery());
    }
}
