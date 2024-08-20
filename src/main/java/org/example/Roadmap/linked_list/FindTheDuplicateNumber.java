package org.example.Roadmap.linked_list;

import java.util.HashSet;
import java.util.Set;
//accepted
public class FindTheDuplicateNumber {
    //Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    //
    //There is only one repeated number in nums, return this repeated number.
    //
    //You must solve the problem without modifying the array nums and uses only constant extra space.
    public static void main(String[] args) {
        int []nums = {3,1,3,4,2};
        System.out.println(findDuplicate1(nums));
    }
    //this method is quite good but its Space Complexity is O(n). we can still get a more optimal solution
    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i: nums) {
            if (!set.add(i)) {
                return i;
            }
        }

        return 0;
    }
    //so why does the problem belong to Linked list category?
    //hint: think of it like linked list cycle problem. Use Hare & Tortoise method.
    //Each integer of nums can be treated like a pointer to the next node. Because there's duplicate number => a cycle exist in the linked list.
    public static int findDuplicate1(int[] nums) {
        int slow = nums[0], fast = nums[0]; //head node

        while (true) {
            slow = nums[slow]; //move slow pointer 1 step
            fast = nums[nums[fast]]; //move fast pointer 2 steps

            if (slow == fast) break;
        }

        // find the head of loop
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
