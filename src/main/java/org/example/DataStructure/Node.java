package org.example.DataStructure;

import java.util.HashMap;
import java.util.Map;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static Node createList(Integer[][] nums) {
        Map<Integer, Node> map = new HashMap<>();
        Node head = new Node(nums[0][0]);
        map.put(0, head);
        Node current = head;

        for (int i=1; i<nums.length; i++) {
            Node newNode = new Node(nums[i][0]);
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

    public static void printList(Node head) {
        Node current = head;
        int i =0;
        Map<Node, Integer> map = new HashMap<>();

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
