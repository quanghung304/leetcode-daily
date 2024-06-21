package org.example.leetcode;

//Passed. Beat 97%
public class LC20240614 {
    //Sum of Square Numbers
    //Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(6));
    }

    public static boolean judgeSquareSum(int c) {
        int a = (int) Math.sqrt(c);
        int halfC = (int) Math.sqrt(c/3);
        while (a>=halfC) {
            int remain = c-a*a;
            if (isPerfectSquare(remain)) {
                return true;
            } else {
                a--;
            }
        }

        return false;
    }

    public static boolean isPerfectSquare(int number) {
        if (number < 0) {
            return false; // Số âm không phải là số chính phương
        }
        double sqrt = Math.sqrt(number);
        int sqrtInt = (int) sqrt;
        return sqrtInt * sqrtInt == number;
    }
}
