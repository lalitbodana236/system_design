package com.lalitbodana.sde.companywise.amazon.lld.splitwise.service;

import com.lalitbodana.sde.companywise.amazon.lld.splitwise.dto.Expense;
import com.lalitbodana.sde.companywise.amazon.lld.splitwise.dto.Split;
import com.lalitbodana.sde.companywise.amazon.lld.splitwise.dto.SplitType;

import java.util.HashMap;
import java.util.Map;

public class ExpenseService {
    Map<String, Expense> expenseMap = new HashMap<>();
    Map<String, Map<String, Integer>> balanceMap = new HashMap<>();
    
    UserService userService;
    
    public ExpenseService(UserService userService) {
        this.userService = userService;
        expenseMap = new HashMap<>();
        balanceMap = new HashMap<>();
    }
    
    public void addExpense(Expense expense) {
        expenseMap.put(expense.getId(), expense);
        if (expense.getType() == SplitType.EQUAL) {
            int splitAmount = expense.getAmount() / expense.getSplits().size();
            for (Split split : expense.getSplits()) {
                String paidTo = split.getUserId();
                if (paidTo.equals(expense.getPaidBy())) continue; // skip self
                
                settleAmount(expense.getPaidBy(),split.getUserId(),splitAmount);
            }
        }
    }
    
   public void settleAmount(String paidBy, String paidTo, int amount) {
       // PaidBy -> PaidTo
        balanceMap
                .computeIfAbsent(paidBy, k -> new HashMap<>())
                .put(paidTo, balanceMap.get(paidBy).getOrDefault(paidTo, 0) + amount);
        
        // PaidTo -> PaidBy (reverse negative entry)
        balanceMap
                .computeIfAbsent(paidTo, k -> new HashMap<>())
                .put(paidBy, balanceMap.get(paidTo).getOrDefault(paidBy, 0) - amount);
        
        
    }
    
    void simplifyDebt() {
    
    }
    
    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Integer> userBalance : balanceMap.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }
    
    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Integer>> allBalances : balanceMap.entrySet()) {
            for (Map.Entry<String, Integer> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }
        if (isEmpty) {
            System.out.println("No balances");
        }
    }
    
    private void printBalance(String user1, String user2, double amount) {
        String user1Name = userService.userMap.get(user1).getName();
        String user2Name = userService.userMap.get(user2).getName();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
    
}

