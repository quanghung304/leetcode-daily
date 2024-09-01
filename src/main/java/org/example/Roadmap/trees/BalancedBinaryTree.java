package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;
//100
public class BalancedBinaryTree {
    //Given a binary tree, determine if it is height-balanced
    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,3,null,null,4,4};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if (traverse(root) >= 1000) return false;
        return true;
    }

    private static int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        if (Math.abs(left-right) > 1) return 1000;

        return Math.max(left, right)+1;
    }
}
