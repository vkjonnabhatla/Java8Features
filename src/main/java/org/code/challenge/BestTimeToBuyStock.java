package org.code.challenge;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyStock {

    public static void main(String[] args) {
        int[] prices = {7, 3, 5, 3, 1, 4};
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(findMaxProfit(prices1));
    }

    public static int findMaxProfit(int[] prices){

        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(min > prices[i]){ // Find the minimum value here
                min = prices[i];
            } else { // If minimum value is less than next day price then take the difference
                max = Math.max(max, prices[i] - min);
            }
        }
        return  max;
    }
}