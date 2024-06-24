package org.example;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class LC20240624 {
    //Minimum Number of K Consecutive Bit Flips
    //You are given a binary array nums and an integer k.
    //A k-bit flip is choosing a subarray of length k from nums and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
    //Return the minimum number of k-bit flips required so that there is no 0 in the array. If it is not possible, return -1.
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;

        System.out.println(minKBitFlips2(nums, k));
    }

    public static int minKBitFlips2(int[] nums, int k) {
        int length = nums.length;
        int[] flipped = new int[length];
        int count = 0;

        for (int i=0; i<=length-k; i++) {
            if (nums[i] == 0) {
                for (int j=0; j<k; j++) {
                    if (nums[i+j] == 0) {
                        nums[i+j] = 1;
                    } else {
                        nums[i+j] = 0;
                    }
                }
                count++;
            }

            if (i == length-k) {
                for (int j=0; j<k; j++) {
                    if (nums[i+j] == 0) {
                        return -1;
                    }
                }
            }
        }

        return count;
    }

    public static int minKBitFlips(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        int i = 0;

        while (i<length) {
            if (nums[i] == 1) {
                i++;
                continue;
            }

            if (nums[i] == 0) {
                if (i+k > length) {
                    return -1;
                }
                int[] subArray = Arrays.copyOfRange(nums, i, i+k);
                int count0 = checkPattern(subArray, k);

                if (count0 == k) {
                    result += 1;
                    i = i+k;
                } else if (count0 < 0) {
                    return count0;
                } else if (i+k+count0-1 < length) {
                    int[] nextSubArray = Arrays.copyOfRange(nums, i+k, i+k+count0);
                    for (int j=0; j<count0; j++) {
                        if (nextSubArray[j] == 1) {
                            return -1;
                        }

                        if (j == count0-1) {
                            result += 2;
                            i = i+k+count0;
                        }
                    }
                } else {
                    return -1;
                }
            }
        }

        return result;
    }

    public static int checkPattern(int[] nums, int k) {
        int count0 = 0;
        int count1 = 0;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] == 0 && count1 == 0) {
                count0++;
            }

            if (nums[i] == 1) {
                count1++;
            }
        }

        if (count0 + count1 == k) {
            return count0;
        }

        return -1;
    }
}
