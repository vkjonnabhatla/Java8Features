package org.code.challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class April_2_5_Last_Stone_Weight {
    public static void main(String[] args) {

        April_2_5_Last_Stone_Weight obj = new April_2_5_Last_Stone_Weight();
        int[] stones = {2, 8, 4, 1,8, 1};
        //Arrays.sort(stones, 0, 3);
        System.out.println(obj.lastStoneWeight2(stones));
    }

    public static int lastStoneWeight2(int[] stones){
      Arrays.sort(stones);
      int index = stones.length - 1;
      while(index > 0){
          stones[index - 1] = stones[index] - stones[index - 1];
          Arrays.sort(stones, 0, index);
          index--;
      }
      return stones[0];
    }

    public int lastStoneWeight() {

        int[] stones = {2, 7, 4, 1,8, 1};
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int val: stones){
            priorityQueue.add(-val);
        }

        while(priorityQueue.size() > 1){
            int two = -priorityQueue.poll();
            int one = -priorityQueue.poll();
            if(one == two){

            }else{
                priorityQueue.add(-(two - one));
            }
        }

        return priorityQueue.isEmpty() ? 0 : -priorityQueue.remove();

       /* List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());

        while(list.size() != 0 || list.size() != 1){
            int x = 0, y = 0;
            for(int i = 0; i < list.size(); i++){
                if(y < list.get(i)){
                    x = y;
                    //y =  Math.max(y, list.get(i));
                }
                y =  Math.max(y, list.get(i));
            }

            if(x == y){
                list.remove(x);
                list.remove(y);
            }

            if(x < y){
                list.remove(new Integer(x));
                int index = list.indexOf(new Integer(y));
                list.set(index, y-x);
            }else{
                list.remove(new Integer(y));
                int index = list.indexOf(new Integer(x));
                list.set(index, x-y);
            }
        }

        if(list.size() == 0){
            return 0;
        }else{
            return list.get(0);
        }*/
    }
}
