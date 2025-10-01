package com.lalitbodana.sde.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    
    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private int rows, cols;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0)
            return result;
        
        rows = heights.length;
        cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // Pacific: top row + left col
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, Integer.MIN_VALUE, pacific);
            dfs(heights, rows - 1, c, Integer.MIN_VALUE, atlantic);
        }
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, r, cols - 1, Integer.MIN_VALUE, atlantic);
        }
        
        // Cells reachable by both
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return;
        if (visited[r][c])
            return;
        if (heights[r][c] < prevHeight)
            return;
        
        visited[r][c] = true;
        
        for (int[] d : directions) {
            dfs(heights, r + d[0], c + d[1], heights[r][c], visited);
        }
    }
}
