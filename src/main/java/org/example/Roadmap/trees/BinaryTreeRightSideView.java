package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    //Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
    // you can see ordered from top to bottom.
    public static void main(String[] args) {
        Integer[] nums = {1,2};
        TreeNode root = TreeNode.buildTree(nums);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                if (i != size-1) queue.poll();
                else result.add(queue.poll().val);
            }
        }

        return result;
    }
}
