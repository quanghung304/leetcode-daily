package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
//solved
public class ReorderList {
    public static void main(String[] args) {
        //You are given the head of a singly linked-list. The list can be represented as:
        //
        //L0 → L1 → … → Ln - 1 → Ln
        //Reorder the list to be on the following form:
        //
        //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
        //You may not modify the values in the list's nodes. Only nodes themselves may be changed.
        int[] nums = {1,2,3,4};
        ListNode head = ListNode.createAList(nums);
        reorderList1(head);
        ListNode.printList(head);
    }
    //first approach: use a deque to store list of nodes. take 1 node from the begin and one from the back to get the order we want.
    public static void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode curNode = head;

        while (curNode != null) {
            deque.offerFirst(curNode);
            curNode = curNode.next;
        }

        curNode = null;
        boolean first = true;

        while (!deque.isEmpty()) {
            if (curNode == null) {
                curNode = deque.pollLast();
                first = false;
                continue;
            }
            if (first) {
                curNode.next = deque.pollLast();
                curNode = curNode.next;
                first = false;
            } else {
                curNode.next = deque.pollFirst();
                curNode = curNode.next;
                first = true;
            }

            if (deque.isEmpty()) curNode.next = null;
        }
    }
    //optimize: cut the list into half, reverse the 2nd half and then merge them into one.
    public static void reorderList1(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = ReverseLinkedList.reverseList(slow.next);
        slow.next = null;

        ListNode node1 = head, node2 = secondHead;
        ListNode next1 = null, next2 = null;

        while (node1 != null || node2 != null) {
            if (node1 != null ) next1 = node1.next;
            if (node2 != null) next2 = node2.next;

            if (node1 != null ) node1.next = node2;
            if (node2 != null) node2.next = next1;

            node1 = next1;
            node2 = next2;
        }
    }
}
