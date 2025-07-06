package com.lalitbodana.lld.ds.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equal {
    public static void main(String[] args) {
    
    }
    
    public ArrayList<Integer> equal(ArrayList<Integer> A) {
        int n = A.size();
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] result = null;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                
                for (int[] pair : map.get(sum)) {
                    int p = pair[0], q = pair[1];
                    
                    // Check all constraints
                    if (p < q && i < j && p < i && q != i && q != j) {
                        int[] candidate = new int[]{p, q, i, j};
                        
                        if (result == null || isLexSmaller(candidate, result)) {
                            result = candidate;
                        }
                    }
                }
                
                map.get(sum).add(new int[]{i, j});
            }
        }
        
        if (result == null) return new ArrayList<>();
        
        ArrayList<Integer> output = new ArrayList<>();
        for (int x : result) output.add(x);
        return output;
    }
    
    private boolean isLexSmaller(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            if (a[i] < b[i]) return true;
            else if (a[i] > b[i]) return false;
        }
        return false;
    }
    
    public ArrayList<Integer> equalOpt(ArrayList<Integer> A) {
        int n = A.size();
        Map<Integer, int[]> map = new HashMap<>();
        int[] result = null;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A.get(i) + A.get(j);
                
                if (map.containsKey(sum)) {
                    int[] prev = map.get(sum);
                    int p = prev[0], q = prev[1];
                    
                    // Check constraints:
                    if (p < q && i < j && p < i && q != i && q != j) {
                        int[] candidate = new int[]{p, q, i, j};
                        if (result == null || isLexSmaller(candidate, result)) {
                            result = candidate;
                        }
                    }
                } else {
                    map.put(sum, new int[]{i, j});
                }
            }
        }
        
        if (result == null) return new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int x : result) output.add(x);
        return output;
    }
    
}
