package com.lalitbodana.resource.designpattern.creational.builder;

public class QueryBuilder {
    private final Query query;
    
    public QueryBuilder() {
        this.query = new Query();
    }
    
    public QueryBuilder select(String[] cols, String table) {
        this.query.setSelect("Select " + String.join(",", cols) + " from " + table);
        return this;
    }
    
    public QueryBuilder where(String col, String value) {
        this.query.setWhere("WHERE " + col + " = " + value);
        return this;
    }
    
    public QueryBuilder groupBy(String groupBy) {
        query.setGroupBy(groupBy);
        return this;
    }
    
    public QueryBuilder having(String having) {
        query.setHaving(having);
        return this;
    }
    
    public Query build() {
        String query = "";
        
        if (this.query.getSelect() == null) {
            throw new RuntimeException("Invalid query. Query cannot be formed without select clause");
        }
        
        if (!this.query.getSelect().isEmpty()) {
            query += this.query.getSelect();
        }
        
        if (this.query.getWhere() != null && !this.query.getWhere().isEmpty()) {
            query += " " + this.query.getWhere();
        }
        this.query.setQuery(query);
        return this.query;
    }
}
