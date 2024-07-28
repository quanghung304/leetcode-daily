package org.example.Roadmap.binary_search;

import java.util.Scanner;

public class SearchInRotatedSortedArray {
    //There is an integer array nums sorted in ascending order (with distinct values).
    //Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
    //such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    //For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
    //Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
    //or -1 if it is not in nums.
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};

        Scanner s = new Scanner(System.in);
        int target;

        while (true) {
            target = s.nextInt();
            if(target == -1) {
                break;
            }
            System.out.println(search(nums, target));
        }
        s.close();
    }

    private static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length-1;
        int middle;

        while (left < right) {
            middle = (left+right)/2;

            if (nums[middle] > nums[right]) {
                left = middle+1;
            } else {
                right = middle;
            }
        }

        if (target <= nums[length-1]) {
            right = length-1;
        } else {
            right = left-1;
            left = 0;
        }

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
