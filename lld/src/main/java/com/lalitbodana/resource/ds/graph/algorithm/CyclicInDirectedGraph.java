package com.lalitbodana.resource.ds.graph.algorithm;

import java.util.ArrayList;

public class CyclicInDirectedGraph {
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] recS = new boolean[v];
        
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, recS)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] recS) {
        vis[v] = true;
        recS[v] = true;
        
        for (Integer neighbor : adj.get(v)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, adj, vis, recS)) {
                    return true;
                }
            } else if (recS[neighbor])
                return true;
        }
        
        recS[v] = false;
        
        return false;
    }
}
