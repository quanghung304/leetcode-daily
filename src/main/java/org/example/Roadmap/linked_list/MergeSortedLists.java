package org.example.Roadmap.linked_list;

import org.example.DataStructure.ListNode;
//accepted
public class MergeSortedLists {
    //You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    //
    //Merge all the linked-lists into one sorted linked-list and return it.
    public static void main(String[] args) {
        int[][] nums = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] lists = new ListNode[nums.length];

        for (int i=0; i<nums.length; i++) {
            ListNode head = ListNode.createAList(nums[i]);
            lists[i] = head;
        }

        ListNode.printList(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return mergeLists(lists, 0, lists.length-1);
    }

    public static ListNode mergeLists(ListNode[] list, int start, int end) {
        if (start == end) return list[start];

        if (start+1 == end) {
            return MergeTwoSortedLists.mergeTwoLists(list[start], list[end]);
        }

        int middle = (start + end)/2;
        ListNode left = mergeLists(list, start, middle);
        ListNode right = mergeLists(list, middle+1, end);
        return MergeTwoSortedLists.mergeTwoLists(left, right);
    }
}
