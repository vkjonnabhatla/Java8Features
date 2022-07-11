package org.heap;

/**
 * Min Heap implementation
 */
public class MinHeapImplementation {

    private int[] heap = null;
    private int size;
    private int maxSize;

    private static int FRONT = 1;

    public MinHeapImplementation(int maxSize){
        this.maxSize = maxSize;
        heap = new int[maxSize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return 2 * pos;
    }

    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos){
        if((2 * pos) > size) {
            return true;
        }
        return false;
    }

    public void insert(int i) {

        if(size >= maxSize){
            return;
        }

        heap[++size] = i;
        int current = size;
        while(heap[current] < heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void minHeapify(int pos){
        if(!isLeaf(pos)){
            int minPos = heap[leftChild(pos)] < heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            if(heap[pos] > heap[minPos]){
                swap(pos, minPos);
                minHeapify(minPos);
            }
        }
    }

    private int remove(){
        int minEle = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return minEle;
    }

    private void swap(int size, int parent) {
        int temp = heap[size];
        heap[size] = heap[parent];
        heap[parent] = temp;
    }

    public void print(){
        for(int i = 1; i <= size / 2; i++){
            System.out.println("Parent : " + heap[i] + " Left child : " + heap[2 * i] + " Right child : "+ heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args){

        System.out.println("The Min Heap is ");
        MinHeapImplementation minHeap = new MinHeapImplementation(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);


        minHeap.print();

        System.out.println("The min value is "+ minHeap.remove());
        System.out.println("The min value is "+ minHeap.remove());
    }
}