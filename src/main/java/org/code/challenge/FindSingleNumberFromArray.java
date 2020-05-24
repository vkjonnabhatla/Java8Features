package org.code.challenge;

public class FindSingleNumberFromArray {

    public static void main(String[] arr){
        int[] nums = {4,1,2,1,2};    //{2,2,1};
        System.out.println(findSingleNumberFromArray(nums));
    }

    public static int findSingleNumberFromArray(int[] nums){
        //int result = nums[0];
        for(int i = 1; i < nums.length; i++)
            nums[0] = nums[0] ^ nums[i];

        return nums[0];
    }
}
