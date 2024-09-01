package org.example.Roadmap.trees;

import org.example.DataStructure.TreeNode;

import java.util.Objects;
//100
public class SameTree {
    //Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    //
    //Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    public static void main(String[] args) {
        Integer[] nums1 = {5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,1929};
        Integer[] nums2 = {5,-685,2970,-755,-462,2770,3620,null,-714,-649,434,373,2913,3337,4201,null,null,null,-497,-400,-95,313,1620,2838,null,3228,3574,3874,4262,-589,-484,null,-225,-183,null,240,null,1357,2342,null,null,2988,3262,3434,null,3658,3885,null,null,-622,null,null,null,-381,null,null,null,150,null,1237,1538,2235,2593,null,3072,null,null,3349,3490,null,3760,null,4187,null,null,null,-325,74,null,701,1246,1439,1583,2136,2249,2553,2661,3053,3174,null,3384,3465,null,3686,3855,3971,null,null,null,null,null,527,913,null,1283,null,null,null,null,1945,2219,null,null,2370,null,null,2694,3007,null,3109,null,null,null,null,null,null,null,null,null,null,4058,519,624,712,972,null,null,1736,1954,null,null,null,2467,2692,null,null,null,null,3115,null,4100,-203,null,null,null,null,725,null,1227,1670,1745,1952,2030,2427,null,null,null,null,null,null,null,null,null,null,817,1056,null,null,null,null,1852,null,null,null,2098,null,null,null,null,null,1133,1834,1929};
        TreeNode p = TreeNode.buildTree(nums1);
        TreeNode q = TreeNode.buildTree(nums2);
        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        Integer pval = p == null ? null : p.val;
        Integer qval = q == null ? null : q.val;
        // == Operator: Compares object references (memory addresses).
        //Java caches Integer objects for values between -128 and 127. If you create two Integer objects with a value within this range,
        // they will point to the same object in memory. Thus, == would return true for those values.
        //However, for values outside this range (like -685 in your example), new Integer objects are created each time.
        // This means p and q are two different objects in memory, even though they represent the same value. => should avoid '=='

        //equals() Method: Compares the actual values of the objects.
        if (!Objects.equals(pval, qval)) {
            return false;
        }

        if (p != null && q != null) {
            if (!isSameTree(p.left, q.left)) return false;
            if (!isSameTree(p.right, q.right)) return false;
        }

        return true;
    }
}
