package com.lalitbodana.lld.ds.tree;

public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;


    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    // Overloaded constructor for easy tree creation
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
