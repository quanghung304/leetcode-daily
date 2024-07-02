package org.example.Roadmap.arrays_and_hashing;

import java.util.Arrays;
//accepted. beats 97%
public class LongestConsecutiveSequence {
    //Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    public static void main(String[] args) {
        int[] nums = {0,1,1,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int max = 0;
        int currentLenght = 1;

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] == nums[i-1] + 1) {
                currentLenght++;
                if (currentLenght > max) max = currentLenght;
            } else {
                currentLenght = 1;
            }
        }

        if (max == 0) {
            return 1;
        }

        return max;
    }
}
