package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;
//5%
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is
    // the inorder traversal of the same tree, construct and return the binary tree.
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.printTreeInOrder(root);
    }
    //recursive is a fine way, but it's not the best option.
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int lenght = preorder.length;
        if (lenght == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int rootIdx = 0;
        for (int i=0; i<lenght; i++) {
            if (inorder[i] == preorder[0]) rootIdx = i;
        }

        int[] leftPre = copyArray(preorder, 1, 1+rootIdx);
        int[] leftIn = copyArray(inorder, 0, rootIdx);
        int[] rightPre = copyArray(preorder, 1+rootIdx, lenght);
        int[] rightIn = copyArray(inorder, 1+rootIdx, lenght);

        TreeNode left = buildTree(leftPre, leftIn);
        TreeNode right = buildTree(rightPre, rightIn);

        root.left = left;
        root.right = right;

        return root;
    }

    static int[] copyArray(int[] nums, int start, int end) {
        int length = end-start;
        int[] result = new int[length];

        for (int i=0; i<length; i++) {
            result[i] = nums[start+i];
        }

        return result;
    }
}
