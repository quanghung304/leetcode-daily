package org.example.Roadmap.two_pointers;
//accepted. beats 70%
public class TrappingRainWater {
    //Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    public static void main(String[] args) {
        int[] height = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(trap(height));
    }
    //Nhan xet: xet cot i bat ky, goi leftMax la cot cao nhat tinh tu 0 -> i, rightMax la tu i -> length-1
    //De y rang ko can quan tam cac cot o giua cao bnh, luong nuoc dc luu trong tai cot i dc tinh bang:
    // min(leftMax, rightMax) - height[i]
    //Thuat toan: dat 2 pointer left va right tai dau va cuoi mang. Neu height[left] < height[right] thi left++ cho den khi
    //height[left] > height[right] thi right--
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int rain = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                rain += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                rain += rightMax - height[right];
                right--;
            }
        }

        return rain;
    }
}
