package com.lalitbodana.resource.ds.graph.algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    
    public int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, i, stack, vis);
            }
        }
        int i = 0;
        int[] ans = new int[v];
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean[] vis) {
        vis[v] = true;
        
        for (Integer neighbor : adj.get(v)) {
            if (!vis[neighbor]) {
                dfs(adj, neighbor, stack, vis);
            }
        }
        
        stack.push(v);
    }
    
    
}
