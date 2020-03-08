package org.code.challenge;

/**
 * O(n*n) time complexity
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 4};
        System.out.println("Before selection sort :: "); printArray(arr);
        System.out.println("\nAfter selection sort :: "); printArray(doSelectionSort(arr));
    }

    public static int[] doSelectionSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            int minimumValueIndex = i;    // Iterate over array from index 1 and find element less than element at minimumValueIndex and put that index into minimumValueIndex variable.
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minimumValueIndex] < arr[j]){
                    minimumValueIndex = j;
                }
            }

            if( minimumValueIndex != i){
                int temp = arr[i];
                arr[i] = arr[minimumValueIndex];
                arr[minimumValueIndex] = temp;
            }
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(" "+arr[i]);
        }
    }
}
