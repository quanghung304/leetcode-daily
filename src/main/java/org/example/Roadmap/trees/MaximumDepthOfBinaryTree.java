package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//accepted
public class MaximumDepthOfBinaryTree {
    //Given the root of a binary tree, return its maximum depth.
    //
    //A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    public static void main(String[] args) {
        Integer[] nums = {0,0,0,0,null,null,0,null,null,null,0};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(maxDepthRecursive(root));
    }
    //DFS: to find max depth we definitely need to use DFS (Depth-First Search) algorithms.
    //In DFS, we use a stack to traverse through the trees, and a set to mark traversed node.
    public static int maxDepth(TreeNode root) {
        if (root == null) return  0;

        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        set.add(root);
        int max = 1;

        while (!stack.isEmpty()) {
             TreeNode node = stack.peek();
             if (node.left != null && !set.contains(node.left)) {
                 stack.push(node.left);
                 set.add(node.left);
                 max = Math.max(max, stack.size());
             } else if (node.right != null && !set.contains(node.right)) {
                 stack.push(node.right);
                 set.add(node.right);
                 max = Math.max(max, stack.size());
             } else {
                 stack.pop();
             }
        }

        return max;
    }
    //Recursion approach: if root == null => the depth is 0. Else, the depth of a node = max(left's depth, right's depth)+1; 1 for the parent node.
    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);

        return Math.max(left, right)+1;
    }
}
