package com.lalitbodana.lld.proxydesignpattern;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void create(String client, Employee obj) throws Exception {
        System.out.println("created new row in the Employee Table");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("deleted row with employeeId" + employeeId);
    }

    @Override
    public Employee get(String client, int employeeId) throws Exception {
        System.out.println("fetching data from the DB");
        return new Employee();
    }
}
