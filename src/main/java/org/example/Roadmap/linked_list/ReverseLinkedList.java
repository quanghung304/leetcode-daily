package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;

public class ReverseLinkedList {
    //Given the head of a singly linked list, reverse the list, and return the reversed list.
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        ListNode head = ListNode.createAList(nums);
        ListNode newHead = reverseList(head);
        ListNode.printList(newHead);
    }
    //use 3 pointers to store prev, cur and next node. next = cur.next
    //iterate throught the list to update cur.next = prev to reverse the cur's pointer, then prev = cur, cur = next for the next step
    public static ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = node;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
