package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;
//100
public class ReverseNodesInKGroup {
    //Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    //
    //k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
    // a multiple of k then left-out nodes, in the end, should remain as it is.
    //
    //You may not alter the values in the list's nodes, only nodes themselves may be changed.
    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6};
        int k = 2;
        ListNode head = ListNode.createAList(nums);
        ListNode.printList(reverseKGroup(head,k));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        int count = 0;
        ListNode curNode = head, temp = new ListNode(), beforeHead = head;
        ListNode newHead = null, tail = beforeHead;

        while (count < k && curNode != null) {
            count++;

            if (count == k) {
                temp.next = curNode.next;
                curNode.next = null;

                ListNode afterHead = ReverseLinkedList.reverseList(beforeHead);

                if (newHead == null) newHead = afterHead;

                tail.next = afterHead;
                tail = beforeHead;

                beforeHead.next = temp.next;
                beforeHead = beforeHead.next;

                count = 0;
                curNode = temp.next;
                continue;
            }

            curNode = curNode.next;
        }

        return newHead;
    }
}
