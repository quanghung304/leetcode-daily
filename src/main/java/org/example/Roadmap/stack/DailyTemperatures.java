package org.example.Roadmap.stack;

import java.util.Stack;
//passed. 76%
public class DailyTemperatures {
    //Given an array of integers temperatures represents the daily temperatures, return an array answer such that
    // answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day
    // for which this is possible, keep answer[i] == 0 instead.
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(temperatures));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int []result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index =  stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}
