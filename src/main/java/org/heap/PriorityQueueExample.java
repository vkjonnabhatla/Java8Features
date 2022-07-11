package org.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> pQueue = new PriorityQueue(); // By default PriorityQueue is min heap.

        pQueue.add(-10); // If you insert negitive values Priority Queueu acts as a max queue.
        pQueue.add(-20);
        pQueue.add(-1);
        pQueue.add(-344);
        pQueue.add(-12);
        pQueue.add(-0);

        Iterator<Integer> iterator = pQueue.iterator();

        System.out.println("Print all elements in the Queue ");
        while(iterator.hasNext())
         System.out.println(iterator.next());

        System.out.println(" pQueue.peek() :: " + (-pQueue.peek())); // Just print the value
        System.out.println(" pQueue.pool() :: " + (-pQueue.poll())); // Remove the element from the queue

        System.out.println("Print all elements in the Queue ");
        iterator = pQueue.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println(" pQueue.pool() :: " + (-pQueue.poll()));

        iterator = pQueue.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
