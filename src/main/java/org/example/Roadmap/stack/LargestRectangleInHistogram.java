package org.example.Roadmap.stack;

import java.util.Stack;
//solved. 43%
public class LargestRectangleInHistogram {
    //Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
    //return the area of the largest rectangle in the histogram.
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    //approach: can tinh dc dien tich cua tat ca cac hinh chu nhat co the dc tao ra de tim dc hcn co dien tich lon nhat.
    //=> voi moi cot i, ta can tinh dc dien tich hinh chu nhat lon nhat ma lay no lam 1 canh
    //=> can tim cot gan nhat thap hon no ve ca 2 phia de ta co the lay dc gioi han cua hcn tao boi cot i.
    //xet cot i, goi left la index cua cot gan nhat < heights[i] ve ben trai, right la ben phai
    //=> dien tich hcn tao boi cot i: heights[i] * (right - left -1)
    public static int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int left[] = new int[length];
        int[] right = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<length; i++) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.empty()) {
            right[stack.pop()] = length;
        }

        for (int i=length-1; i>-1; i--) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                left[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.empty()) {
            left[stack.pop()] = -1;
        }

        int max = 0;
        for (int i=0; i<length; i++) {
            int s = (right[i] - left[i] - 1) * heights[i];
            if (max < s) {
                max = s;
            }
        }

        return max;
    }
}
