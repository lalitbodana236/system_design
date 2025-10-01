package com.lalitbodana.sde.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUnidirectedGraph {
    
    
    
    public boolean checkForCycleUsingBFS(int src, int V, List<List<Integer>> adj,boolean[] vis){
        vis[src]=true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,-1));
        while(!queue.isEmpty()){
            int node= queue.peek().first;
            int parent = queue.peek().second;
            queue.remove();
            for(int adjNode : adj.get(node)){
                if(!vis[adjNode]){
                    vis[adjNode]=true;
                    queue.add(new Pair(adjNode,node));
                } else if (parent!=adjNode) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkForCycleDFS(int src,int parent,List<List<Integer>> adj,boolean[] vis){
        vis[src]=true;
        
        for(Integer adjNode : adj.get(src)){
            if(!vis[adjNode]){
                if(checkForCycleDFS(adjNode,src,adj,vis)){
                    return true;
                }
            }else if (adjNode!=parent) {
                return true;
            }
        }
        
        return false;
    }
    
    
    public boolean isCycle(int V, List<List<Integer>> adj){
        boolean[] vis = new boolean[V];
        
        Arrays.fill(vis,false);
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(checkForCycleUsingBFS(i,V,adj,vis)) return true;
            }
        }
        
        return false;
    }
}

class Pair{
    
    int first;
    
    int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
