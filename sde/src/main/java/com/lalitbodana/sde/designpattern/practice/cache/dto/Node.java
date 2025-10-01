package com.lalitbodana.sde.designpattern.practice.cache.dto;

public class Node {
  public   int key;
   public  int value;
    
   public Node prev;
   
    public Node next;
    
    public Node(int k,int v) {
        this.key= k;
        this.value = v;
    }
}
