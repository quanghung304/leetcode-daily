package org.example.DataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeMethod {
    public static TreeNode buildBSTFromArray(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i =0;
        while (i < array.length) {
            if (array[i] != null) {
                TreeNode newNode = new TreeNode(array[i]);
                queue.offer(newNode); //add an element
                TreeNode currentNode = queue.peek(); //return the first element

                if (newNode.getVal() < currentNode.getVal()) {
                    currentNode.setLeft(newNode);
                } else {
                    currentNode.setRight(newNode);
                    queue.poll(); //pop the first element out
                }
            } else {

            }

            i++;
        }

        return root;
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
