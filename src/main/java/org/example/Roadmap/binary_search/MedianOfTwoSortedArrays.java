package org.example.Roadmap.binary_search;
//100
public class MedianOfTwoSortedArrays {
    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    //
    //The overall run time complexity should be O(log (m+n)).
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int combinedLength = nums1.length + nums2.length;
        int[] combined = new int[combinedLength];

        int i=0,j=0;
        while (i<nums1.length || j< nums2.length) {
            if (i == nums1.length) {
                combined[i + j] = nums2[j];
                j++;
                continue;
            } else if (j == nums2.length) {
                combined[i+j] = nums1[i];
                i++;
                continue;
            }

            if (nums1[i] <= nums2[j]) {
                combined[i + j] = nums1[i];
                i++;
            } else {
                combined[i+j] = nums2[j];
                j++;
            }
        }

        if (combinedLength%2 != 0) {
            return combined[combinedLength/2];
        } else {
            return (double) (combined[combinedLength / 2 - 1] + combined[combinedLength / 2]) /2;
        }
    }
}
