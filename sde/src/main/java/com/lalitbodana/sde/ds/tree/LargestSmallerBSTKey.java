package com.lalitbodana.sde.ds.tree;

public class LargestSmallerBSTKey {
    TreeNode root;
    
    public int search(int num) {
        int result = -1;
        TreeNode currentNode = root;
        
        while (currentNode != null) {
            if (currentNode.key < num) {
                result = currentNode.key;
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        
        return result;
    }
}
