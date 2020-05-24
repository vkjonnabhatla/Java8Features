package org.code.challenge;

/**
 * Brute force approach: Time Complexity of this approach is O(n*2)
 * Best approach: Dynamic programming with divide and conquer approach
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMaxSubArraySum(arr));
    }

    public static int getMaxSubArraySum(int[] arr){
        int maxValue = arr[0];
        for(int i = 0; i < arr.length; i++){
            int result = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                result = result + arr[j];
                maxValue = Math.max(result, maxValue);
            }
        }
        return maxValue;
    }
}



