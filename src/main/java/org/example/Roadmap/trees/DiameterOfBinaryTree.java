package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.*;

public class DiameterOfBinaryTree {
    //Given the root of a binary tree, return the length of the diameter of the tree.
    //
    //The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    //
    //The length of a path between two nodes is represented by the number of edges between them.
    public static void main(String[] args) {
//        Integer nums[] = {4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        Integer nums[] = {1,2,3,4,5};
        TreeNode root = TreeNode.buildTree(nums);
//        TreeNode.printTreeInOrder(root);
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        System.out.println(tree.diameterOfBinaryTree(root));
    }
    //brute force: add the height of left and right tree of each node => diameter of this node => find max
    public static int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) return  0;

        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        set.add(root);
        int max = 0, left =0, rigth =0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.right != null && !set.contains(node.right)) {
                rigth = MaximumDepthOfBinaryTree.maxDepthRecursive(node.right);
                queue.offer(node.right);
                set.add(node.right);
            }
            if (node.left != null && !set.contains(node.left)) {
                left = MaximumDepthOfBinaryTree.maxDepthRecursive(node.left);
                queue.offer(node.left);
                set.add(node.left);
            }

            max = Math.max(max, left+rigth);
            left=0; rigth=0;
            queue.poll();
        }

        return max;
    }
    //recursive:
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return result;
    }

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);
        int currDiameter = left + right;
        result = Math.max(result, currDiameter);
        return Math.max(left, right) + 1;
    }
}
