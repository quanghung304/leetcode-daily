package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;

public class MergeTwoSortedLists {
    //You are given the heads of two sorted linked lists list1 and list2.
    //
    //Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
    //
    //Return the head of the merged linked list.
    public static void main(String[] args) {
        int[] list1 = {1,2,4};
        int []list2 = {1,3,5};
        ListNode head1 = ListNode.createAList(list1);
        ListNode head2 = ListNode.createAList(list2);
        ListNode head = mergeTwoLists(head1, head2);
        ListNode.printList(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), curNode = head;
        ListNode next1, next2;

        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val <= list2.val) ) {
                next1 = list1.next;
                curNode.next = list1;
                list1 = next1;
                curNode = curNode.next;
            } else {
                next2 = list2.next;
                curNode.next = list2;
                list2 = next2;
                curNode = curNode.next;
            }
        }

        return head.next;
    }
}
