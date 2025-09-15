package com.lalitbodana.sde.pattern.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    
    private List<List<Integer>> adjacencyList;  // For list representation
    private int[][] adjacencyMatrix;            // For matrix representation
    private int vertices;
    
    // Constructor for adjacency list
    public Graph(int v) {
        this.vertices = v;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    
    // Constructor for adjacency matrix
    public Graph(int v, boolean useMatrix) {
        this.vertices = v;
        if (useMatrix) {
            adjacencyMatrix = new int[v][v];
        } else {
            adjacencyList = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }
    }
    
    // Add edge (for adjacency list)
    public void addEdgeList(int source, int dest) {
        adjacencyList.get(source).add(dest);
        adjacencyList.get(dest).add(source); // undirected
    }
    
    // Add edge (for adjacency matrix)
    public void addEdgeMatrix(int source, int dest, int val) {
        adjacencyMatrix[source][dest] = val;
        adjacencyMatrix[dest][source] = val; // undirected
    }
    
    // Print adjacency list
    public void printAdjList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
    // Print adjacency matrix
    public void printAdjMatrix() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Adjacency List
        Graph g1 = new Graph(5);
        g1.addEdgeList(0, 1);
        g1.addEdgeList(0, 4);
        g1.addEdgeList(1, 2);
        g1.printAdjList();
        
        // Adjacency Matrix
        Graph g2 = new Graph(5, true);
        g2.addEdgeMatrix(0, 1, 1);
        g2.addEdgeMatrix(0, 4, 1);
        g2.addEdgeMatrix(1, 2, 1);
        g2.printAdjMatrix();
    }
}
