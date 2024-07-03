package org.example.Roadmap.two_pointers;

import java.util.*;
//accepted. beats 70%
public class ThreeSum {
    //Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    //
    //Notice that the solution set must not contain duplicate triplets.
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            List<List<Integer>> indices = twoSum(nums, - nums[i],i+1, nums.length-1);
            if (!indices.isEmpty()) {
                result.addAll(indices);
            }
        }

        return result;
    }

    public static List<List<Integer>> twoSum(int[] numbers, int target, int left, int right) {
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            if (numbers[right] + numbers[left] == target) {
                result.add(List.of(numbers[right], numbers[left], - target));
                left++;
                while (numbers[left] == numbers[left-1] && left < right) {
                    left++;
                }
            } else if (numbers[right] + numbers[left] > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
