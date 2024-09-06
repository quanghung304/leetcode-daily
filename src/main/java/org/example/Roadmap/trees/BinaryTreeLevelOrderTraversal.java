package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.*;
//accepted
public class BinaryTreeLevelOrderTraversal {
    //Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    public static void main(String[] args) {
        Integer []nums = {};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(levelOrder(root));
    }
    //Approach: DFS, of course. But with each loop through queue, we keep only nodes on the same level in the queue.
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            //with each level-node, add its child nodes to queue and then poll it out => keep only nodes on the same level in the queue.
            for(int i=0; i < level; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                list.add(queue.poll().val);
            }
            result.add(list);
        }

        return result;
    }
}
