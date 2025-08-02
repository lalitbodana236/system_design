package com.lalitbodana.resource.ds.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreorderAndInorder {
    
    private Map<Integer, Integer> inorderMap;
    
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};  //DLR
        int[] inorder = {9, 3, 15, 20, 7};  //LDR
        
        //Create a node with data preorder[s1]
        //find [s1] in inorder array
        // calculate the no of element
        // idx-s2=x;
        // for left subtree (preorder,s1+1,s1+x,inorder,s2,idx-1)
        // for right subtree (preorder,s1+x+1,e1,inorder,idx+1,e2)
        // s1>e1
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        //  Brute-force part: linear search
        int rootIndexInInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }
        
        int leftSize = rootIndexInInorder - inStart;
        
        root.left = helper(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndexInInorder - 1);
        
        root.right = helper(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndexInInorder + 1, inEnd);
        
        return root;
    }
    
    public TreeNode buildTreeOpt(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        // Map inorder value → index
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1, 0);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart) {
        if (preStart > preEnd) return null;
        
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inorderMap.get(rootVal);
        int leftSize = rootIndex - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1);
        
        return root;
    }
}
