package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;
//100
public class KthSmallestElementInBST {
    //Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed)
    // of all the values of the nodes in the tree.
    public static void main(String[] args) {
        Integer nums[] = {5,3,6,2,4,null,null,1};
        int k = 4;
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(kthSmallest(root, k));
    }
    //approach: which traverse algorithm give us the sorted array of BST'values? In-order traversal.
    //=> whenever traverse to a node, we add 1 to the count variable till we get k => that's the node we need.
    static int i = 0;
    static int result;

    public static int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public static void traverse(TreeNode root, int k) {
        if (root == null) {
            return ;
        }
        traverse(root.left, k);
        i++;
        if (i== k) result = root.val;
        traverse(root.right, k);
    }
}
