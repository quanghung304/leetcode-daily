package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0,2,2};
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int[] unique = Arrays.stream(sorted).distinct().toArray();

        for (int i=0; i<sorted.length; i++) {
//            if (Arrays.stream(unique).c)
        }

        int uIndex = 0;
        int uniqueValue = unique[uIndex]+1;
        for (int i=1; i<unique.length; i++) {
            if (uniqueValue == unique[i]) {
                uniqueValue = unique[i]+1;
                uIndex = i;
            } else {
                break;
            }
        }

        int existValue = sorted[0];
        for (int i=1; i<sorted.length; i++) {
            if (sorted[i] == existValue) {
                sorted[i] = uniqueValue;
                if (uIndex < unique.length) {
                    while (uniqueValue == unique[uIndex]) {
                        uniqueValue = unique[uIndex]+1;
                        uIndex++;
                    }
                }
                uniqueValue++;
            }
            if (sorted[i] > existValue) {

            }
            existValue = sorted[i];
        }

        int baseSum = Arrays.stream(nums).sum();
        return Arrays.stream(sorted).sum() -baseSum ;
    }
}