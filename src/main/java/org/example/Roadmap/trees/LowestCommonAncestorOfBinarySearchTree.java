package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;
//100
public class LowestCommonAncestorOfBinarySearchTree {
    //Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
    //
    //According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
    // the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
    public static void main(String[] args) {
        Integer nums[] = {6,2,8,0,4,7,9,null,null,3,5};
        int num1 = 2, num2 = 4;
        TreeNode root = TreeNode.buildTree(nums);
        TreeNode p = TreeNode.findNode(root, num1);
        TreeNode q = TreeNode.findNode(root, num2);
        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);

        while (root != null) {
            if (root.val >= min && root.val <= max) return root;

            if (root.val < min) root = root.right;
            else root = root.left;
        }

        return null;
    }
}
