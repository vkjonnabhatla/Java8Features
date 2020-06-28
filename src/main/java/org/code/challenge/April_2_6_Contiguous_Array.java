package org.code.challenge;

import java.util.Arrays;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class April_2_6_Contiguous_Array {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,0,1};
        findMaxLength1(arr);
    }
    // Brute force method with O(n^2) and space complexity O(1)
    public static int findMaxLength(int[] arr) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++){
            int zeros = 0, ones = 0;
            for(int j = i; j < arr.length; j++){
                int k = i;
                int l = j;
                if(arr[j] == 0){
                    zeros++;
                }else{
                    ones++;
                }
                if(zeros == ones){
                    maxLength = Math.max(maxLength, j - i + 1);
                }
                //It prints all sub arrays
                System.out.print("[");
                while(k <= l){
                    System.out.print(arr[k] + " ");
                    k++;

                }
                System.out.print("]");
                System.out.println();
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }

    public static int findMaxLength1(int[] nums) {
        int res=0;

        int[] count=new int[nums.length*2+1];
        Arrays.fill(count,-1);
        int cur=count.length/2;
        count[cur]=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                cur--;
            else
                cur++;

            if(count[cur]!=-1){
                res=Math.max(res,i+1-count[cur]);
            }
            else
                count[cur]=i+1;
        }

        return res;
    }



}
