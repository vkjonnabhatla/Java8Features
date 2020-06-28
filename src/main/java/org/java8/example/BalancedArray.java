package org.java8.example;

import java.util.ArrayList;
import java.util.List;

public class BalancedArray {

    public static void main(String[] args) {
        int[] arr = {-2, -3, 1, 2, -1, 0, 3, 2, 2};
        System.out.println(isBalancedArray(arr));
    }

    public static boolean isBalancedArray(int[] arr){
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                negative.add(arr[i]);
            }else{
                positive.add(arr[i]);
            }
        }

        for(int j = 0; j < negative.size(); j++){
            if(positive.contains(- negative.get((j)))){
                positive.remove(Integer.valueOf(- negative.get((j))));
            }else{
                return false;
            }
        }

        if(positive.size() == 1 && positive.get(0) == 0){
            return true;
        }
        return false;
    }
}
