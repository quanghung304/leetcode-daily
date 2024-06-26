package org.example.DataStructure;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode () {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
