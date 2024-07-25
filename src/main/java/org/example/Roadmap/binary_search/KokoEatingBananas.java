package org.example.Roadmap.binary_search;

import java.util.Arrays;
//accepted. 66%
public class KokoEatingBananas {
    //Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone
    // and will come back in h hours.
    //Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from
    //that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    //Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    //Return the minimum integer k such that she can eat all the bananas within h hours.
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int length = piles.length;

        int low = 1;
        int high = piles[length-1];
        int possibleAnswer = high;

        while (low < high) {
            int mid = (high + low)/2;
            boolean possible = canEatAll(piles, h, mid);

            if (possible) {
                high=mid;
            } else {
                possibleAnswer = mid;
                low = mid+1;
            }
        }

        if (high == low && canEatAll(piles, h, low)) {
            return low;
        }

        return possibleAnswer;
    }

    public static boolean canEatAll(int[] piles, int h, int speed) {
        int sumTime = 0;

        for (int pile: piles) {
            sumTime += pile/speed + (pile%speed > 0 ? 1 : 0);
        }

        if (sumTime <= h) {
            return true;
        }

        return false;
    }
}
