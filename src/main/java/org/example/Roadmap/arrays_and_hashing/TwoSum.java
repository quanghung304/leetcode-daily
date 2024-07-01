package org.example.Roadmap.arrays_and_hashing;

import java.util.HashMap;
import java.util.Map;
//accepted. beats 98%
public class TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        for(int i: twoSum(nums, target)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            Integer counterpart = map.get(target - nums[i]);

            if (counterpart != null) {
                return new int[]{counterpart, i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
