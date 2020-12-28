package org.code.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        removeDuplicates(arr);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> array = new HashSet<>();
        array.addAll(Arrays.stream(nums).boxed().collect(Collectors.toSet()));
        nums = array.stream().mapToInt(i -> i).toArray();
        return nums.length;
    }


}
