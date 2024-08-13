package org.example.DataStructure;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createAList(int[] nums) {
        ListNode head = null;
        ListNode curNode = new ListNode();

        for (int i: nums) {
            if (Objects.isNull(head)) {
                head = new ListNode(i);
                curNode = head;
                continue;
            }

            ListNode newNode = new ListNode(i);
            curNode.next = newNode;
            curNode = newNode;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curNode = head;

        while (curNode != null) {
            System.out.println(curNode.val);
            curNode = curNode.next;
        }
    }

    public static int getSize(ListNode head) {
        int count = 0;
        ListNode curNode = head;

        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }

        return count;
    }
}
