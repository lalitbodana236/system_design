package com.lalitbodana.resource.grind169;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    
    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        mi.merge(intervals);
    }
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        
        result.add(currentInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}
