package org.code.challenge;

/**
 *  O(log n time complexity)
 *  For a list of 8 elements, log 8 == 3, because 2^3 == 8. So for a list of 8 numbers, you would have to check 3 numbers at most.
 *  For a list of 1,024 elements, log 1,024 = 10, because 2^10 == 1,024. So for a list of 1,024 numbers, you’d have to check 10 numbers at most.
 */
public class BinarySearch {

    public static void main(String[] args) {
        //int[] arr = {1, 2, 4, 6, 8, 9, 10, 23, 45, 76, 232, 2222};
        int[] arr = {1, 2, 3, 4, 5}; // The while condition should be while(start <= end) in case if search element is 2
        int index = binarySearch(arr, 2);
        if (index >= 0) {
            System.out.println(" Element found @ " + index);
        } else {
            System.out.println(" Search element not present in the given array.");
        }
    }

    public static int binarySearch(int[] arr, int searchElement) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end)  {
            int mid = (start + end) / 2;
            if (searchElement == arr[mid]) {
                return mid;
            } else if (searchElement > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
