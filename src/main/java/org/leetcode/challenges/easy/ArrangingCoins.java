package org.leetcode.challenges.easy;
// Leetcode 441
public class ArrangingCoins {

    // O(logn) Binary search solution
    public static void main(String[] args) {
        ArrangingCoins obj = new ArrangingCoins();
        obj.arrangeCoins(5);
    }

    public int arrangeCoins(int n){
        int l = 1, r = n;
        int res = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            int coins = (mid * (mid + 1)) / 2;   // n(n + 1)/2 : this formula useful to take the sum of from 1 to n

            if(coins > n){
                r = mid - 1;
            }else {
                l = mid + 1;
                res = Math.max(mid, res); // We need to take the max number of rows when coins are less than the n
            }
            //res = Math.max(mid, res);
        }
        return  res;
    }



}
