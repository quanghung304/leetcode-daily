package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;
//100
public class AddTwoNumbers {
    //You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
    // and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    //
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    public static void main(String[] args) {
        int[] l1 = {9,9,9,9,9,9,9}, l2 = {9,9,9,9};
        ListNode head1 = ListNode.createAList(l1);
        ListNode head2 = ListNode.createAList(l2);
        ListNode.printList(addTwoNumbers(head1, head2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, current = head;
        int remember = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int value = val1 + val2 + remember;
            if (value >= 10) {
                value -= 10;
                remember = 1;
            } else {
                remember = 0;
            }

            ListNode newNode = new ListNode(value);
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (head == null) {
                head = newNode;
                current = newNode;
                continue;
            }

            current.next = newNode;
            current = current.next;
        }

        if (remember == 1) {
            ListNode newNode = new ListNode(remember);
            current.next = newNode;
        }

        return head;
    }
}
