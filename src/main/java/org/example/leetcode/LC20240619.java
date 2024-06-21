package org.example.leetcode;

import java.util.Arrays;

//Passed.
public class LC20240619 {
    //Minimum Number of Days to Make m Bouquets
    //Problem: You are given an integer array bloomDay, an integer m and an integer k.
    //You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
    //The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
    //Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

    //Approaches: truong hop nho nhat m=k=1 => result la min of BloomDay. Truong hop lon nhat: max of bloomDay.
    //=> de tim so ngay nho nhat co the: dung binary search tu min den max of bloomDay.
    //doi voi tung ngay dc xet: check xem co the dc hoa khong = ham isPossibleBouquets
    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m=2, k=3;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        //dung (long) m*k: cast m sang long truoc => m*k duoc luu dang long
        //ko dung long total = m*k: m*k luu dang int => bi gioi han o maximum value for int (2,147,483,647) => cast sang long bi sai
        if((long) m*k > bloomDay.length) {
            return -1;
        }

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while (low < high) {
            int mid = (low+high)/2;
            boolean possible = isPossibleBouquets(bloomDay, m, k, mid);
            if (possible) {
                high=mid;
            } else {
                low = mid+1;
            }
        }

        return high;
    }

    public static boolean isPossibleBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquetNum = 0;
        int flowerNum = 0;
        for (int i=0; i<bloomDay.length && bouquetNum<m; i++) {
            if (bloomDay[i] <= days) {
                flowerNum++;
            } else {
                flowerNum=0;
            }

            if (flowerNum==k) {
                flowerNum = 0;
                bouquetNum++;
            }
        }

        if (bouquetNum == m) {
            return true;
        } else {
            return false;
        }
    }
}
