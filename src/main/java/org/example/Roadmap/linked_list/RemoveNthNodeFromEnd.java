package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;

public class RemoveNthNodeFromEnd {
    //Given the head of a linked list, remove the nth node from the end of the list and return its head.
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int n = 2;
        ListNode head = ListNode.createAList(nums);
        ListNode.printList(removeNthFromEnd(head, n));
    }
    //I found out that 2 pointers is a useful method to deal with linked list problems. As we can't move backward a linked list,
    //so one of the pointers helps us keep track on the browsed nodes.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = null, fast = null;

        for(int i=1; i<=n; i++) {
            if (i == 1) {
                fast = head;
                continue;
            }
            if(fast != null) fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            if (slow == null) {
                slow = head;
                continue;
            }
            slow = slow.next;
        }

        if (slow == null) return head.next;

        if(slow.next != null) {
            slow.next = slow.next.next;
        } else return null;

        return head;
    }
}
