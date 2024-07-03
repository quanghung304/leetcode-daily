package org.example.Roadmap.two_pointers;

public class TwoSumII_InputArrayIsSorted {
    //Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up
    //to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    //
    //Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    //
    //The tests are generated such that there is exactly one solution. You may not use the same element twice.
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        for (int i: twoSum(nums, target)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            if (numbers[right] + numbers[left] == target) {
                break;
            } else if (numbers[right] + numbers[left] > target) {
                right--;
                continue;
            } else {
                left++;
                continue;
            }
        }

        return new int[]{left+1, right+1};
    }
}
