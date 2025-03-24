package com.lalitbodana.lld.ds.tree;

import java.util.*;

public class TreeUtils {
    // Data -> L -> R
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);

        preorder(root.left);
        preorder(root.right);
    }

    // L -> Data -> R
    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    // L -> R-> Data
    public void postorder(TreeNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);

    }


    public List<List<Integer>> levelorder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                if (current.left != null) queue.add(current.left);

                if (current.right != null) queue.add(current.right);
            }

            result.add(level);
        }
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return depth;
    }

    public void leafNodes(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left == null && current.right == null) {
                System.out.print(current.val + " ");
            }

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public void leftView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (i == 0) System.out.println(current.val);
                if (current.left != null) queue.add(current.left);

                if (current.right != null) queue.add(current.right);
            }
        }
    }

    public void rightView(TreeNode root) {

        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();


            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (i == size - 1) System.out.println(current.val);

                if (current.left != null) queue.add(current.left);

                if (current.right != null) queue.add(current.right);
            }
        }
    }

    //left view + leaf node + right view
    public void boundryView(TreeNode root) {

        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();


            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (i == size) System.out.println(current.val);

                if (current.left != null) queue.add(current.left);

                if (current.right != null) queue.add(current.right);
            }


        }

    }


    public void verticalView(TreeNode root) {
        if (root == null) return;

        // TreeMap to store vertical order mapping: {horizontalDistance -> List of nodes}
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        // Start with root at horizontal distance 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            TreeNode node = temp.node;
            int hd = temp.hd; // horizontal distance

            // Store nodes at this horizontal distance
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(node.val);

            // Process left and right children
            if (node.left != null) queue.add(new Pair(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair(node.right, hd + 1));
        }

        // Print nodes in vertical order
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int val : entry.getValue()) {
                System.out.print(val + " ");
            }
            System.out.println(); // New line for each vertical column
        }
    }

    public void topView(TreeNode root) {

    }

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
