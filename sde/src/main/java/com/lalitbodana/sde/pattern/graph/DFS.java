package com.lalitbodana.sde.pattern.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    
    public void dfs(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];   // track visited nodes
        List<Integer> ans = new ArrayList<>(); // store traversal order
        
        dfs(0, adj, visited, ans); // start DFS from node 0
        
        System.out.println(ans);   // print result
    }
    
    // Recursive DFS
    private void dfs(int v, List<List<Integer>> adj, boolean[] visited, List<Integer> ans) {
        visited[v] = true;
        ans.add(v);
        
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, ans);
            }
        }
    }
}
