package com.lalitbodana.lld.designpattern.creational.builder;

public class BuilderTestRunner {
    public static void main(String[] args) {
        String sb = "This" +
                            "is" +
                            "example";
        sb;
        QueryBuilder builder = new QueryBuilder();
        Query query = builder
                              .select(new String[]{"name", "age"}, "users")
                              .where("name", "John")
                              .build();
        System.out.println(query.getQuery());
    }
}
