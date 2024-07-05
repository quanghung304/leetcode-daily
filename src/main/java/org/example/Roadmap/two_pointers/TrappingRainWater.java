package org.example.Roadmap.two_pointers;

public class TrappingRainWater {
    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int left = 0;
        int rain = 0;
        int occupied = 0;

        while (height[left] == 0) {
            left++;
        }

        int right = left+1;

        int[] leftI = new int[height.length];
        int[] rightI = new int[height.length];
        leftI[0] = left;
        height[0] = right;

        while (right < height.length) {

        }

        while (right < height.length) {
            if (height[right] == 0) {
                right++;
                continue;
            } else {
                if (height[right] < height[left]) {
                    occupied += height[right];
                    right++;
                } else {
                    int h = Math.min(height[left], height[right]);
                    rain += h * (right-left-1) - occupied;
                    left = right;
                    right++;
                }
            }
        }

        return rain;
    }
}
