package org.example.Roadmap.arrays_and_hashing;

import java.util.*;

public class TopKFrequentElements {
    //Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] nums1 = {-1,-1};
        int k1 = 1;
        int[] nums2 = {1};
        int k2 = 1;
        for (int i: topKFrequent(nums2, k2)) {
            System.out.println(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            Integer count = map.get(num);

            if (count == null) {
                map.put(num, 1);
                if (1>max) {
                    max=1;
                }
            } else {
                map.put(num, count+1);
                if (count+1>max) {
                    max=count+1;
                }
            }
        }

        int[] bucket = new int[max+1];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            bucket[entry.getValue()] = entry.getKey();
        }

        int[] result = new int[k];
        int index = 0, j=bucket.length-1;
        for (int i=max; i>max-k; i--) {
            result[index] = bucket[i];
            index++;
        }

        return result;
    }
}
