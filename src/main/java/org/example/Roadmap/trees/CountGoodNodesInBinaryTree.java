package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//7.8
public class CountGoodNodesInBinaryTree {
    //Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
    //
    //Return the number of good nodes in the binary tree.
    public static void main(String[] args) {
        Integer []nums = {3,1,4,3,null,1,5};
        TreeNode root = TreeNode.buildTree(nums);

        CountGoodNodesInBinaryTree ans = new CountGoodNodesInBinaryTree();
        System.out.println(ans.goodNodes(root));
    }

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();

            if (node.left != null) {
                TreeNode left = node.left;
                queue.offer(left);

                if (left.val >= node.val) result++;
                else left.val = node.val;
            }

            if (node.right != null) {
                TreeNode right = node.right;
                queue.offer(right);

                if (right.val >= node.val) result++;
                else right.val = node.val;
            }

            queue.poll();
        }

        return result;
    }
}
