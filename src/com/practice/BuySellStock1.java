package com.practice;

public class BuySellStock1 {

    public static void main(String[] args) {
        BuySellStock1 b = new BuySellStock1();
        System.out.print(b.maxProfit(new int[]{1, 2,3,4,5,6,7}));
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public int maxProfit(int[] prices) {

        if(prices.length == 0) return 0;

        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {

            if(prices[i] < low) {
                low = prices[i] ;
            } else if(prices[i] > low && (prices[i] - low) > profit) {
                profit = prices[i] - low;
            }
        }

        return profit;
    }
}
