package com.lalitbodana.resource.ds.practice;

public class DayOfTheYear {
    public static void main(String[] args) {
    
    }
    
    
    public int dayOfYear(String date) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int count = 0;
        
        for (int i = 0; i < month - 1; i++) {
            count += monthDays[i];
        }
        
        if (month > 2 && isLeapYear(year)) {
            return count + day + 1;
        }
        
        return count + day;
    }
    
    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}
