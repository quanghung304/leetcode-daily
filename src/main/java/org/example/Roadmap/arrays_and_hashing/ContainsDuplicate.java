package org.example.Roadmap.arrays_and_hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public static void main(String[] args) {
        int[] nums = {1,5,-2,-4,0};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) { //set.add() return true if the insertion is success, false if the element was already present
                return true;
            }
        }

        return false;
    }
}
