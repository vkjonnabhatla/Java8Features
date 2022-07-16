package org.leetcode.challenges.easy;

import java.util.*;

public class LexDfs {

    public static void main(String[] args) {
        List<Integer> gFrom = new ArrayList<>();
        gFrom.add(0);gFrom.add(1);gFrom.add(2);gFrom.add(3);

        List<Integer> gTo = new ArrayList<>();
        gTo.add(1);gTo.add(2);gTo.add(3);gTo.add(0);

        List<Integer> r = new ArrayList<>();
        r.add(0);//r.add(0);r.add(2);

        List<Integer> v = new ArrayList<>();
        v.add(2);//v.add(2);v.add(1);

        /*List<Integer> gFrom = new ArrayList<>();
        gFrom.add(0);gFrom.add(3);gFrom.add(1);gFrom.add(0);gFrom.add(1);gFrom.add(2);

        List<Integer> gTo = new ArrayList<>();
        gTo.add(3);gTo.add(4);gTo.add(2);gTo.add(1);gTo.add(3);gTo.add(4);

        List<Integer> r = new ArrayList<>();
        r.add(0);r.add(3);r.add(2);r.add(1);

        List<Integer> v = new ArrayList<>();
        v.add(1);v.add(4);v.add(4);v.add(2);*/

        System.out.println(lexdfs(0, gFrom, gTo, r, v));
    }

    public static List<Integer> lexdfs(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> r, List<Integer> v){

        List<Integer> result = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = constructGraph(gFrom, gTo);
        System.out.println(graph);
        for(int i = 0; i < r.size(); i++){
            result.add(traverseGraph(graph, r.get(i), v.get(i)));
        }
        System.out.println(result);
        return result;
    }

    public static int traverseGraph(Map<Integer, Set<Integer>> graphMap, int r, int v){
        if(r == v){
            return 0;
        }

        List<Integer> visited = new ArrayList<>();
        //visited.add(r);
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        //Stack<Integer> queue = new Stack<>();
        queue.add(r);
        while(!queue.isEmpty() && queue.peek() != v){
           if(!visited.contains(queue.peek())){
               Integer val = queue.poll();
               visited.add(val);
               count++;
               Set<Integer> set = graphMap.get(val);
               if(set != null){
                   //queue.addAll(set);
                   queue.clear();
                   queue.addAll(set);
               }
           }else{
               queue.poll();
           }
        }
        return visited.size() ;
    }

    public static Map<Integer, Set<Integer>> constructGraph(List<Integer> gFrom, List<Integer> gTo){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < gFrom.size(); i++){
            if(!map.containsKey(gFrom.get(i))){
                Set<Integer> set = new TreeSet<>();
                set.add(gTo.get(i));
                map.put(gFrom.get(i), set);
            }else{
                Set<Integer> set = map.get(gFrom.get(i));
                set.add(gTo.get(i));
            }
        }

        for(int i = 0; i < gFrom.size(); i++){
            if(!map.containsKey(gTo.get(i))){
                Set<Integer> set = new TreeSet<>();
                set.add(gFrom.get(i));
                map.put(gTo.get(i), set);
            }else{
                Set<Integer> set = map.get(gTo.get(i));
                set.add(gFrom.get(i));
            }
        }

        return map;
    }
}
