package com.lalitbodana.lld.structural.proxydesignpattern;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = new EmployeeDaoProxy();
            employeeDao.create("ADMIN", new Employee());
            System.out.println("Operation successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
