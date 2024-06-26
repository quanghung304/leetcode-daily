package org.example;

import org.example.DataStructure.TreeNode;

import static org.example.DataStructure.TreeNodeMethod.*;

public class LC20240625 {
    //Binary Search Tree to Greater Sum Tree
    //Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
    //
    //As a reminder, a binary search tree is a tree that satisfies these constraints:
    //
    //The left subtree of a node contains only nodes with keys less than the node's key.
    //The right subtree of a node contains only nodes with keys greater than the node's key.
    //Both the left and right subtrees must also be binary search trees.
    public static void main(String[] args) {
        Integer[] array = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = buildBSTFromArray(array);
        printTreeInOrder(root);
    }

    public TreeNode bstToGst(TreeNode root) {
        return null;
    }
}
