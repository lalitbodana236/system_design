package com.lalitbodana.sde.pattern.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    
    
    public void bfs(int[][] grid, int start) {
        int n = grid.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from "start" vertex
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // process the node
            
            // Explore neighbors
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (grid[node][neighbor] != 0 && !visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    
    public void bfs(List<List<Integer>> adj, int start) {
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " "); // process node
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
