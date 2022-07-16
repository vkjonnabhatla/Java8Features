package org.leetcode.challenges.medium;

//Leetcode 179

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] nums = {10,2,9,39,17};
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.solution2(nums));
    }

    public String largestNumber(int[] nums) {


        StringBuilder sb = new StringBuilder("");

        for(int i = 1; i < nums.length; i++){
            if(sb.length() == 0){
                sb.append(""+nums[0]);
            }
            int res = compare(sb.toString(), String.valueOf(nums[i]));
            if(res == -1){
                sb.append(String.valueOf(nums[i]));
            }else if(res == 1){
                sb = new StringBuilder(String.valueOf(nums[i]) + sb.toString());
            }else{
                sb.append(String.valueOf(nums[i]));
            }
        }

        return sb.toString();
    }

    public int compare(String str1, String str2){
        long n1 = Long.parseLong(str1.concat(str2));
        long n2 = Long.parseLong(str2.concat(str1));
        if(n1 > n2){
            return -1;
        }else if(n2 > n1){
            return 1;
        }else{
            return 0;
        }
    }


    public String solution(int[] nums){

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                String s1 = String.valueOf(nums[i]);
                String s2 = String.valueOf(nums[j]);
                String res1 = s1.concat(s2);
                String res2 = s2.concat(s1);
                if(Integer.parseInt(res2) > Integer.parseInt(res1)){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i]);
        }

        if(sb.toString().charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }


    public String solution2(int[] nums){
        StringBuilder sb = new StringBuilder("");
        List<String> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(String.valueOf(nums[i]));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String res1 = o1 + o2;
                String res2 = o2 + o1;

                if(Long.parseLong(res1) > Long.parseLong(res2)){
                    return -1;
                }else if(Long.parseLong(res1) < Long.parseLong(res2)){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        System.out.println(list);


        for(String s : list){
            sb.append(s);
        }

        if(sb.toString().charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }

}
