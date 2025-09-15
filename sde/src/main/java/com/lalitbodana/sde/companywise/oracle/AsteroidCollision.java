package com.lalitbodana.sde.companywise.oracle;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        
        for(Integer asteroid : asteroids ){
            boolean isAlive=true;
            
            while(!stack.isEmpty() && asteroid<0 && stack.peek() > 0){
                if(Math.abs(asteroid)>stack.peek()){
                    stack.pop();
                }else if(Math.abs(asteroid)==stack.peek()){
                    stack.pop();
                    isAlive=false;
                    break;
                }else{
                    isAlive=false;
                    break;
                }
            }
            
            if(isAlive) stack.push(asteroid);
        }
        
        int[] res = new int[stack.size()];
        
        for(int i =res.length-1;i>=0;i--){
            res[i]=stack.pop();
        }
        
        return res;
    }
}
