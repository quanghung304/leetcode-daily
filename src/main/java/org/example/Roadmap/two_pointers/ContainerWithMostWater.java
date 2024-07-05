package org.example.Roadmap.two_pointers;
//accepted. beats 88%
public class ContainerWithMostWater {
    //You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    //
    //Find two lines that together with the x-axis form a container, such that the container contains the most water.
    //
    //Return the maximum amount of water a container can store.
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = (right-left) * h;
            if (max < area) max = area;

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
