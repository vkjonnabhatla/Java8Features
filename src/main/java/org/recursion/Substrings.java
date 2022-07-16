package org.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity O(2 pow n)
 */
public class Substrings {

    public static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        //List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentSub = new ArrayList<>();

        int[] arr = {1, 2, 3, 4};

        Substrings obj = new Substrings();
        obj.allSubstrings(currentSub, 0, arr, arr.length);
        System.out.println(result);
    }

    private void allSubstrings(List<Integer> currentSub, int pos, int[] arr, int n){

        if(pos >= n){
            List<Integer> list = new ArrayList<>(currentSub);
            result.add(list);
            return;
        }
        allSubstrings(currentSub, pos + 1, arr, n);
        currentSub.add(arr[pos]);
        allSubstrings(currentSub, pos + 1, arr, n);
        currentSub.remove(currentSub.size() - 1);
    }
}
