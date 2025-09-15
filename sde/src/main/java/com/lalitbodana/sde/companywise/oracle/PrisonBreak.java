package com.lalitbodana.sde.companywise.oracle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrisonBreak {
    int prisonBreak(int n, int m, List<Integer> h, List<Integer> v) {
        Collections.sort(h);
        Collections.sort(v);
        
        int maxH = 1, streak = 1;
        for (int i = 1; i < h.size(); i++) {
            if (h.get(i) == h.get(i - 1) + 1) {
                streak++;
            } else {
                streak = 1;
            }
            maxH = Math.max(maxH, streak);
        }
        
        int maxV = 1;
        streak = 1;
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i) == v.get(i - 1) + 1) {
                streak++;
            } else {
                streak = 1;
            }
            maxV = Math.max(maxV, streak);
        }
        
        return (maxH + 1) * (maxV + 1);
    }
    
    
}
