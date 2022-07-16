package org.leetcode.challenges.easy;

import java.util.*;

public class ComponentsInGraph {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        list.add(integerList);
        integerList = new ArrayList<>();
        integerList.add(1); integerList.add(6);
        list.add(integerList);
        integerList = new ArrayList<>();
        integerList.add(2); integerList.add(7);
        list.add(integerList);
        integerList = new ArrayList<>();
        integerList.add(3); integerList.add(8);
        list.add(integerList);
        integerList = new ArrayList<>();
        integerList.add(4); integerList.add(9);
        list.add(integerList);
        integerList = new ArrayList<>();
        integerList.add(2); integerList.add(6);
        list.add(integerList);
        System.out.println(list);
        //componentsInGraph(list);
        //Scanner in = new Scanner(System.in);
        int N = list.get(0).get(0);
        Graph G = new Graph(N);
        for (int i = 1; i <= N; i++) {
            int n1 = list.get(i).get(0);
            int n2 = list.get(i).get(1);
            G.set_edge(n1, n2);
        }

        G.print_answer();
    }

    static class Graph {
        HashMap<Integer, ArrayList<Integer>> nodes;
        Graph (int n) {
            nodes = new HashMap<>();
            for (int i = 1; i <= 2*n; i++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                nodes.put(i, list);
            }
        }

        void set_edge(int n1, int n2) {
            ArrayList<Integer> list1 = nodes.get(n1);
            ArrayList<Integer> list2 = nodes.get(n2);
            if (list1 != list2) {
                list1.addAll(list2);
                list2.forEach(i -> {
                    System.out.println(list2);
                    System.out.println(i);
                    System.out.println(list2);
                    nodes.put(i, list1);
                });
            }
        }

        void print_answer() {
            ArrayList<Integer> vertices = new ArrayList<Integer>();

            for (ArrayList<Integer> list : nodes.values()) {
                if (list.size() > 1)
                    vertices.add(list.size());
                list.clear();
            }
            System.out.print(Collections.min(vertices) + " ");
            System.out.println(Collections.max(vertices));
        }
    }


    /*public static List<Integer> componentsInGraph(List<List<Integer>> gb) {


        int n = gb.get(0).get(0);
        int[] flag = new int[2 * n];
        int count = 0;
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 1; i <= 2 * n; i++){
            if(map.get(gb.get(i).get(0)) != null){
                List<Integer> list  = gb.get(i);
                list.add(gb.get(i).get(1));
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(gb.get(i).get(1));
                map.put(gb.get(i).get(0), list);
               // map.put(gb.get(i).get(1), )
            }

        }
        System.out.println(map);
        for(int i = 1; i <= n; i++){
            if(flag[i] != 1){
                flag[i] = 1;
                if(map.get(i) != null)
                dfs(map, flag, map.get(i), count);
                result.add(count);
                count = 0;
            }

        }

        Collections.sort(result);
        List newList = new ArrayList();
        newList.add(result.get(0));
        newList.add(result.get(result.size()));
        return newList;
    }

    public static void dfs(Map<Integer, List<Integer>> map, int[] flag, List<Integer> list, int count){
        for(int i = 0; i < list.size(); i++){
            if(flag[list.get(i)] != 1){
                flag[list.get(i)] = 1;
                count++;
                if(map.get(list.get(i)) != null)
                dfs(map, flag, map.get(list.get(i)), count);
            }

        }
    }*/
}
