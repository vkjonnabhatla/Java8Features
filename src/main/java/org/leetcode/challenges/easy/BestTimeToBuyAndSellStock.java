package org.leetcode.challenges.easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        int[] prices = {};
        obj.solution(prices);
    }

    public int solution(int[] prices){
        int max = 0, left = 0, right = 0;
        left = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(left > prices[i])  left = prices[i];
            else{
                right = prices[i];
                max = Math.max((right - left), max);
            }
        }
        return max;
    }
}
