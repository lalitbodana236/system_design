package com.lalitbodana.resource.ds.tree;

public class ConstructBinaryTree {
    public static void main(String[] args) {
        TreeConcepts tc = new TreeConcepts();
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode t = tc.buildTree(arr);
        tc.inorder(t);
    }
}
