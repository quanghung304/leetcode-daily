package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

public class ValidateBinarySearchTree {
    //Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    //
    //A valid BST is defined as follows:
    //
    //The left subtree of a node contains only nodes with keys less than the node's key.
    //The right subtree of a node contains only nodes with keys greater than the node's key.
    //Both the left and right subtrees must also be binary search trees.
    public static void main(String[] args) {
        Integer nums[] = {5,4,6,null,null,3,7};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    //approach: think about possible range of each node's value.
    // Given root: -infinity < root.val < infinity.
    // Then the range of root's left node value : -infinity < root.val < root.val
    // Then the range of root's right node value : root.val < root.val < infinity
    private static boolean valid(TreeNode root, long min, long max) {
        if (root == null) return true;

        if (min >= root.val || root.val >= max) return false;

        if (!valid(root.left, min, root.val) || !valid(root.right, root.val, max)) return false;

        return true;
    }
}
