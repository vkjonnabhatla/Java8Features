package org.heap;

public class MaxHeapImplementation {

    private int[] heap;
    private int size;
    private int maxSize;

    private static int FRONT = 1;

    public MaxHeapImplementation(int maxSize){
        this.maxSize = maxSize;
        heap = new int[maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return 2 * pos;
    }

    private int rightChild(int pos){
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos){
        if( (2 * pos) > size){
            return true;
        }
        return false;
    }

    public void insert(int i){

        if(size >= maxSize){
            return;
        }

        heap[++size] = i;
        int current = size;

        while(heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }

    }

    public void swap(int current, int parent){
        int temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }

    public void maxHeapify(int pos){
        if(!isLeaf(pos)){
            int childMaxPos = heap[leftChild(pos)] > heap[rightChild(pos)] ? leftChild(pos) : rightChild(pos);
            if(heap[pos] < heap[childMaxPos]){
                swap(pos, childMaxPos);
                maxHeapify(childMaxPos);
            }
        }
    }

    public int remove(){
        int max = heap[FRONT];
        heap[FRONT] = heap[size--];
        maxHeapify(FRONT);
        return max;
    }

    public void print(){
        for(int i = 1; i <= size / 2; i++){
            System.out.println(" Parent : "+ heap[i] + " Left child : "+ heap[2  * i] + " Right child : " + heap[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("The Max Heap is ");
        MaxHeapImplementation maxHeap = new MaxHeapImplementation(15);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);


        maxHeap.print();

        System.out.println("The Max value is "+ maxHeap.remove());
        System.out.println("The Max value is "+ maxHeap.remove());
        System.out.println("The Max value is "+ maxHeap.remove());
    }
}
