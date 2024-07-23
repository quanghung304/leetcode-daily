package org.example.Roadmap.binary_search;

import java.util.Arrays;
import java.util.Scanner;
//accepted. 100%
public class Search2DMatrix {
    //You are given an m x n integer matrix matrix with the following two properties:
    //
    //Each row is sorted in non-decreasing order.
    //The first integer of each row is greater than the last integer of the previous row.
    //Given an integer target, return true if target is in matrix or false otherwise.
    //
    //You must write a solution in O(log(m * n)) time complexity.
    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20}, {23,30,34,60}};
        int[][] matrix = {{1}};
        Scanner input = new Scanner(System.in);
        int target = 3;
        while (true) {
            target = input.nextInt();
            if (target == 0) {
                break;
            }
            System.out.println(searchMatrix(matrix, target));
        }
        input.close();

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int []firstElements = new int[m];

        for (int i=0; i<m; i++) {
            firstElements[i] = matrix[i][0];
        }

        int firstElement = searchTheFirst(firstElements, target);

        if (firstElement == -1) return false;

        int find = BinarySearch.search(matrix[firstElement], target);

        if (find == -1) return false;

        return true;
    }

    public static int searchTheFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        if (target < nums[0]) {
            return -1;
        }

        if (target > nums[right]) {
            return right;
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

        return right;
    }
}
