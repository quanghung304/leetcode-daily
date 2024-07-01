package org.example.Roadmap.arrays_and_hashing;
//accepted. beats 87%
public class ProductofArrayExceptSelf {
    //Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    //The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    //You must write an algorithm that runs in O(n) time and without using the division operation.
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        for (int i: productExceptSelf(nums)) {
            System.out.println(i);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] preProduct = new int[length];
        int[] postProduct = new int[length];

        int product = 1;
        for (int i=0; i<length; i++) {
            if (i==0) {
                preProduct[i] = product;
            } else {
                product *= nums[i-1];
                preProduct[i] = product;
            }
        }

        product = 1;
        for (int i=length-1; i>=0; i--) {
            if (i==length-1) {
                postProduct[i] = product;
            } else {
                product *= nums[i+1];
                postProduct[i] = product;
            }
        }

        int[] result = new int[length];
        for (int i=0; i<length; i++) {
            result[i] = preProduct[i] * postProduct[i];
        }

        return result;
    }
}
