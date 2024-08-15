package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListCycle {
    //Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
    //Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    //
    //Return true if there is a cycle in the linked list. Otherwise, return false.
    public static void main(String[] args) {
        int nums[] = {3,2,0,-4};
        int pos = 1;
        ListNode head = ListNode.createAList(nums, pos);

        System.out.println(hasCycle(head));
    }
    //brute force: use a set to store browsed nodes
    public static boolean hasCycle(ListNode head) {
        ListNode curNode = head;
        Set<ListNode> set = new HashSet<>();


        while (curNode != null) {
            if (set.contains(curNode)) {
                return true;
            }

            set.add(curNode);
            curNode = curNode.next;
        }

        return false;
    }
    //Optimize: use 2 pointers, fast and slow that move in difference speed. If there is a cycle, the fast pointer will eventually catch up to the slow pointer.
    public static boolean hasCycle1(ListNode head) {
        ListNode fast=head, slow=head;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) return false;

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
