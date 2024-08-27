package org.example.Roadmap.tree;

import org.example.DataStructure.TreeNode;
//100
public class InvertBinaryTree {
    //Given the root of a binary tree, invert the tree, and return its root.
    //Input: root = [2,1,3]
    //Output: [2,3,1]
    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.buildTree(nums);
        TreeNode newRoot = invertTree(root);
        TreeNode.printTreeInOrder(newRoot);
    }
    //pretty ez. first we invert the left tree, seconde invert the right tree. And then we set left = right and right = left
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
