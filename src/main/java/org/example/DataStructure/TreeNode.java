package org.example.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode () {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildBinarySearchTree(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i =1;
        while (i < array.length) {
            if (array[i] != null) {
                TreeNode newNode = new TreeNode(array[i]);
                queue.offer(newNode); //add an element
                TreeNode currentNode = queue.peek(); //return the first element

                if (newNode.val < currentNode.val) {
                    currentNode.left = newNode;
                } else {
                    currentNode.right = newNode;
                    queue.poll(); //pop the first element out
                }
            }

            i++;
        }

        return root;
    }

    public static TreeNode buildTree(Integer []array) {
        if (array.length == 0) return null;

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i=1;
        while (i < array.length) {
            TreeNode currentNode = queue.peek();
            TreeNode node = null;

            if (array[i] != null) {
                node = new TreeNode(array[i]);
                queue.offer(node);
            }

            if (i%2 == 1) {
                currentNode.left = node;
            } else {
                currentNode.right = node;
                queue.poll();
            }

            i++;
        }

        return root;
    }

    public static TreeNode findNode(TreeNode node, int val) {
        while (node != null) {
            if (node.val == val) return node;

            if (val > node.val) node = node.right;
            else node = node.left;
        }

        return null;
    }

    public static void printTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printTreeInOrder(root.left);
        System.out.print(root.val + " ");
        printTreeInOrder(root.right);
    }
}
