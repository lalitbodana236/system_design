package com.lalitbodana.resource.designpattern.creational.builder;

public class Query {
    private String select;
    
    private String where;
    
    private String groupBy;
    
    private String having;
    
    private String query;
    
    public String getSelect() {
        return select;
    }
    
    public void setSelect(String select) {
        this.select = select;
    }
    
    public String getWhere() {
        return where;
    }
    
    public void setWhere(String where) {
        this.where = where;
    }
    
    public String getGroupBy() {
        return groupBy;
    }
    
    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }
    
    public String getHaving() {
        return having;
    }
    
    public void setHaving(String having) {
        this.having = having;
    }
    
    public String getQuery() {
        return query;
    }
    
    public void setQuery(String query) {
        this.query = query;
    }
}
