package org.example.DataStructure;

import java.util.HashMap;
import java.util.Map;

public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static RandomNode createList(Integer[][] nums) {
        Map<Integer, RandomNode> map = new HashMap<>();
        RandomNode head = new RandomNode(nums[0][0]);
        map.put(0, head);
        RandomNode current = head;

        for (int i=1; i<nums.length; i++) {
            RandomNode newNode = new RandomNode(nums[i][0]);
            map.put(i, newNode);
            current.next = newNode;
            current = newNode;
        }

        current = head;
        for (int i=0; i<nums.length; i++) {
            if (nums[i][1] == null) {
                current.random = null;
                current = current.next;
                continue;
            }

            current.random = map.get(nums[i][1]);
            current = current.next;
        }

        return head;
    }

    public static void printList(RandomNode head) {
        RandomNode current = head;
        int i =0;
        Map<RandomNode, Integer> map = new HashMap<>();

        while (current != null) {
            map.put(current, i);
            current = current.next;
            i++;
        }

        current = head;
        while (current != null) {
            Integer index = map.get(current.random) == null ? null : map.get(current.random);
            System.out.println(current.val + ", " + index);
            current = current.next;
        }
    }
}
