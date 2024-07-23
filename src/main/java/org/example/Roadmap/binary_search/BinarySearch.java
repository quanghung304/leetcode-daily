package org.example.Roadmap.binary_search;

public class BinarySearch {
    //Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
    // search target in nums. If target exists, then return its index. Otherwise, return -1.
    //
    //You must write an algorithm with O(log n) runtime complexity.
    public static void main(String[] args) {
        int[] nums = {1,2};
        int target = 3;
//        int[] nums = {2,5};
//        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {
            middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
