package com.lalitbodana.resource.companywise.amazon.lld.splitwise;

import com.lalitbodana.resource.companywise.amazon.lld.splitwise.dto.EqualSplit;
import com.lalitbodana.resource.companywise.amazon.lld.splitwise.dto.Expense;
import com.lalitbodana.resource.companywise.amazon.lld.splitwise.dto.SplitType;
import com.lalitbodana.resource.companywise.amazon.lld.splitwise.dto.User;
import com.lalitbodana.resource.companywise.amazon.lld.splitwise.service.ExpenseService;
import com.lalitbodana.resource.companywise.amazon.lld.splitwise.service.UserService;

import java.util.Arrays;

public class ExpenseManager {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ExpenseService expenseService = new ExpenseService(userService);
        
        userService.addUser("u1", "Lalit", "9876543210");
        userService.addUser("u2", "Vishal", "9876543210");
        userService.addUser("u3", "Mohit", "9876543210");
        
        User u1 = userService.getUserMap().get("Lalit");
        User u2 = userService.getUserMap().get("Vishal");
        User u3 = userService.getUserMap().get("Mohit");
        
        Expense expense = new Expense(
                300,
                u1.getName(),
                SplitType.EQUAL,
                Arrays.asList(new EqualSplit(u1.getName()), new EqualSplit(u2.getName()), new EqualSplit(u3.getName()))
        );
        
        expenseService.addExpense(expense);
        System.out.println("\n🔍 Showing individual balance:");
        expenseService.showBalance(u1.getName());
        
        System.out.println("\n📊 Showing all balances:");
        expenseService.showBalances();
        
        
    }
    
}
