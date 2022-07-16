package org.leetcode.challenges.medium;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static Integer length = 0, start = -1, end = -1, final_start = 0, final_end = 0;
    public static void main(String[] args) {

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.print(obj.longestPalindrome("babad"));
    }


    public String longestPalindrome(String s) {
        System.out.println(-126 / 10);
        int length = 0;
        AtomicInteger final_start = new AtomicInteger();
        AtomicInteger final_end = new AtomicInteger();
        AtomicInteger start = new AtomicInteger(-1);
        AtomicInteger end = new AtomicInteger(-1);
        for(int i = 0; i < s.length(); i++){

            int x = check(s, i, i, start, end);

            if(x > length){
                length = x;
                final_start.set(start.get());
                final_end.set(end.get());
            }

            int y = check(s, i, i+1, start, end);

            if(y > length){
                length = y;
                final_start.set(start.get());
                final_end.set(end.get());
            }


        }
        return s.substring(final_start.get(), final_end.get() + 1);
    }

    private int check(String s, int p1, int p2, AtomicInteger start, AtomicInteger end) {
        int count = 0;
        if(p1 == p2){
            p1--;
            p2++;
            count++;
        }

        while(p1 >=0 && p2 < s.length()){
            if(s.charAt(p1) != s.charAt(p2)){
                start.set(p1 + 1);
                end.set(p2 - 1);
                return count;
            }else{
                p1--;
                p2++;
                count += 2;
            }
        }

        start.set(p1 + 1);
        end.set(p2 -1);
        return count;
    }


}
