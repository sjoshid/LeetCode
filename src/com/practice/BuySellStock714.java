package com.practice;

public class BuySellStock714 {

    public static void main(String[] args) {
        BuySellStock714 b = new BuySellStock714();
        b.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);

    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
            System.out.println("");
        }
        return cash;
    }

}
