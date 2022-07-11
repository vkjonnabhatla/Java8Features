package org.heap;

public class HeapSort {

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);

    }

    private void sort(int[] arr) {
        int n = arr.length;
        for(int i = (n/2 - 1); i >= 0; i--){
            maxHeapify(i, arr, n);
        }

        for(int i = n - 1; i >=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(0, arr, i);
        }

    }

    private static void printArray(int[] arr) {
        System.out.println("Sorted elements ");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return (2 * pos) + 1;
    }

    private int rightChild(int pos){
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos, int n){
        if( ((2 * pos) + 1) > n){
            return true;
        }
        return false;
    }

    public void swap(int current, int parent, int[] arr){
        int temp = arr[current];
        arr[current] = arr[parent];
        arr[parent] = temp;
    }

    public void maxHeapify(int pos, int[] arr, int n){
        if(!isLeaf(pos, n)){
            if(rightChild(pos) < n && leftChild(pos) < n){
                int childMaxPos = arr[leftChild(pos)] > arr[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
                if(arr[pos] < arr[childMaxPos]){
                    swap(pos, childMaxPos, arr);
                    maxHeapify(childMaxPos, arr, n);
                }
            }else if(leftChild(pos) < n){
                if(arr[pos] < arr[leftChild(pos)]){
                    swap(pos, leftChild(pos),arr);
                }
            }else if(rightChild(pos) < n){
                if(arr[pos] < arr[rightChild(pos)]){
                    swap(pos, rightChild(pos), arr);
                }
            }
        }
    }
}
