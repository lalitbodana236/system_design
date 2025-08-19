package com.lalitbodana.sde.lld.cache.dto;

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
