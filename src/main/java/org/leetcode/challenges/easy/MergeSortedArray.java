package org.leetcode.challenges.easy;

public class MergeSortedArray {
    public static void main(String[] args) {
       merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
       System.out.println();
    }

    /**
     * Approach 2 : two pointer approach starting from beginning
     * Time complexity : O(n + m) Space complexity : O(m)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] nums1_copy = new int[m];
       for(int k = 0; k < m; k++){
           nums1_copy[k] = nums1[k];
       }

       int p1 = 0, p2 = 0, p = 0;

       while((p1 < m) && (p2 < n)){
           nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];
       }

       if (p1 < m){
           for (int i = p1; i < m; i++)
               nums1[p++] = nums1_copy[i];
       }

       if (p2 < n){
          for (int i = p2; i < n; i++)
              nums1[p++] = nums2[i];
       }

       for (int i = 0; i < nums1.length; i++){
           System.out.print(nums1[i] + " ");
       }
    }

    /**
     * Approach 3: Two pointer apporach/ starting from end
     * Time complexity : O(n + m) Space complexity : O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1;
        int p = nums1.length - 1;

        while(p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        if(p2 >= 0){
            for(int i = p2; i >= 0; i--){
                nums1[p--] = nums2[i];
            }
        }

        for (int i = 0; i < nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}
