package com.lalitbodana.resource.ds.graph.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
    public ArrayList<Integer> topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] inDeg = new int[v];
        
        for (ArrayList<Integer> list : adj) {
            for (Integer e : list) {
                inDeg[e]++;
            }
        }
        
        boolean[] vis = new boolean[v];
        ArrayList<Integer> ansList = new ArrayList<>();
        bfs(adj, v, 0, vis, ansList, inDeg);
        return ansList;
    }
    
    private void bfs(ArrayList<ArrayList<Integer>> adj, int v, int i, boolean[] vis, ArrayList<Integer> ansList, int[] inDeg) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int j = 0; j < v; j++) {
            if (inDeg[j] == 0) {
                queue.add(j);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ansList.add(cur);
            
            for (int neighbor : adj.get(cur)) {
                if (--inDeg[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
    }
    
    
}
