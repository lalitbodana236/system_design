package com.lalitbodana.sde.ds.tree;

import java.util.*;

public class TreeConcepts {

    public static void main(String[] args) {
        TreeConcepts tree = new TreeConcepts();
//
//        TreeNode root = new TreeNode(1,
//                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
//                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
//
//        System.out.println("Inorder Traversal:");
//        tree.inorder(root);
//        System.out.println("\nPreorder Traversal:");
//        tree.preorder(root);
//        System.out.println("\nPostorder Traversal:");
//        tree.postorder(root);
//        System.out.println("\nLevel Order Traversal:");
//        tree.levelOrder(root);
//        System.out.println("\nLeft View:");
//        tree.leftView(root);
//        System.out.println("\nRight View:");
//        tree.rightView(root);
//        System.out.println("\nTop View:");
//        tree.topView(root);
//        System.out.println("\nVertical Order:");
//        tree.verticalOrder(root);
//        System.out.println("\nBoundary Traversal:");
//        tree.boundaryTraversal(root);
//        System.out.println("\nSum of All Nodes: " + tree.sumOfNodes(root));

        Integer[] arr = {1, 2, 3, 4, null, null, null}; // Example tree
        TreeNode root = tree.buildTree(arr);

        System.out.println("Tree Structure:");
        tree.printTree(root, 0);
    }

    public TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Add right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public void printTree(TreeNode root, int level) {
        if (root == null) return;

        // Print right subtree first (so it appears on the right side)
        printTree(root.right, level + 1);

        // Print the current node
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) System.out.print("   ");
            System.out.println("  /\\");
            for (int i = 0; i < level - 1; i++) System.out.print("   ");
            System.out.println(" /  \\");
            for (int i = 0; i < level - 1; i++) System.out.print("   ");
        }
        System.out.println("(" + root.val + ")");

        // Print left subtree
        printTree(root.left, level + 1);
    }

    // Inorder Traversal (Left -> Root -> Right)
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Preorder Traversal (Root -> Left -> Right)
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // Level Order Traversal (BFS)
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    // Height of the tree
    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // Depth of a node
    public int depth(TreeNode root, TreeNode target, int level) {
        if (root == null) return -1;
        if (root == target) return level;
        int left = depth(root.left, target, level + 1);
        return left != -1 ? left : depth(root.right, target, level + 1);
    }

    // Left View
    public void leftView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) System.out.print(curr.val + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

    // Right View
    public void rightView(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == size - 1) System.out.print(curr.val + " ");
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

    // Top View
    public void topView(TreeNode root) {
        if (root == null) return;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            TreeNode curr = temp.node;
            int hd = temp.hd;
            if (!map.containsKey(hd)) map.put(hd, curr.val);
            if (curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if (curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }
        for (int value : map.values()) System.out.print(value + " ");
    }

    // Vertical Order Traversal
    public void verticalOrder(TreeNode root) {
        if (root == null) return;
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            TreeNode curr = temp.node;
            int hd = temp.hd;
            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(curr.val);
            if (curr.left != null) queue.add(new Pair(curr.left, hd - 1));
            if (curr.right != null) queue.add(new Pair(curr.right, hd + 1));
        }
        for (List<Integer> values : map.values()) {
            for (int value : values) System.out.print(value + " ");
            System.out.println();
        }
    }

    // Leaf Nodes
    public void printLeaves(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    // Lowest Common Ancestor (LCA)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    // Sum of All Nodes
    public int sumOfNodes(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    // Boundary Traversal
    public void boundaryTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    private void printLeftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        System.out.print(root.val + " ");
        if (root.left != null) printLeftBoundary(root.left);
        else printLeftBoundary(root.right);
    }

    private void printRightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right != null) printRightBoundary(root.right);
        else printRightBoundary(root.left);
        System.out.print(root.val + " ");
    }
}
