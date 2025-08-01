package com.lalitbodana.sde.structural.proxydesignpattern;

public interface EmployeeDao {

    void create(String client, Employee obj) throws Exception;

    void delete(String client, int employeeId) throws Exception;

    Employee get(String client, int employeeId) throws Exception;
}
