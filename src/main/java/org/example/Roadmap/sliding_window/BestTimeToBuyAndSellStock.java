package org.example.Roadmap.sliding_window;
//70
public class BestTimeToBuyAndSellStock {
    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int cheepest = prices[0], maxPrice = 0, maxProfit = 0;

        for (int i=1; i<prices.length; i++) {
            if (prices[i] < cheepest) cheepest = prices[i];

            if (prices[i] > cheepest) {
                int profit = prices[i] - cheepest;

                if (profit > maxProfit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
