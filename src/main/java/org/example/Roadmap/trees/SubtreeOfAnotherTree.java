package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.Objects;

public class SubtreeOfAnotherTree {
    //Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure
    // and node values of subRoot and false otherwise.
    //
    //A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
    // The tree tree could also be considered as a subtree of itself.
    public static void main(String[] args) {
        Integer[] nums1 = {3,4,5,1,null,2};
        Integer[] nums2 = {3,1,2};
        TreeNode root = TreeNode.buildTree(nums1);
        TreeNode subRoot = TreeNode.buildTree(nums2);
        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (Objects.equals(root.val, subRoot.val)) {
            if (SameTree.isSameTreeFaster(root, subRoot)) return true;
        }

        if (isSubtree(root.left, subRoot)) return true;
        if (isSubtree(root.right, subRoot)) return true;

        return false;
    }
}
