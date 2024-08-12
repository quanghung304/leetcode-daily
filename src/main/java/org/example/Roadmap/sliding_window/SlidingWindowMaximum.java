package org.example.Roadmap.sliding_window;

import java.util.*;

public class SlidingWindowMaximum {
    //You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array
    // to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
    //
    //Return the max sliding window.
    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k=5;
        System.out.println(Arrays.toString(maxSlidingWindow1(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int []ans = new int[nums.length-k+1];
        Deque<Integer> window = new ArrayDeque<>();

        return ans;
    }

    static class IntegerComparator implements Comparator<Integer> {

        // Overriding compare()method of Comparator
        // for descending order of cgpa
        public int compare(Integer s1, Integer s2) {
            if (s1 < s2)
                return 1;
            else if (s1 > s2)
                return -1;
            return 0;
        }
    }
    //O(N * k): do numbers.remove(nums[i-k]) co do phuc tap la O(k)
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int []ans = new int[nums.length-k+1];
        //queue dung de luu phan tu lon nhat
        Queue<Integer> numbers = new PriorityQueue<>(new IntegerComparator());

        for (int i=0; i<nums.length; i++) {
            if (i<k) {
                numbers.offer(nums[i]);
                if (i == k-1) ans[i - (k-1)] = numbers.peek();
                continue;
            }

            // if (numbers.peek() != null && nums[i-k] == numbers.peek()) {
            numbers.remove(nums[i-k]);
            // }

            numbers.offer(nums[i]);
            ans[i - (k-1)] = numbers.peek();
        }

        return ans;
    }
}
