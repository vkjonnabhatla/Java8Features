package org.data.structures.graphs.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoadsAndLibraries {
    public static void main(String[] args) {

    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        //Construct adjacent list
        //List<List<Integer>> adjacentList = new ArrayList<>();
        //System.out.println("c_lib :: "+ c_lib);
        //System.out.println("c_road :: "+ c_road);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] visited = new int[n+1];
        for(int i = 0; i < cities.size(); i++){
            if(map.get(cities.get(i).get(0)) != null){
                List<Integer> temp1 = map.get(cities.get(i).get(0));
                temp1.add(cities.get(i).get(1));
            }else{
                List<Integer> values = new ArrayList<>();
                values.add(cities.get(i).get(1));
                map.put(cities.get(i).get(0), values);
            }

            if(map.get(cities.get(i).get(1)) != null){
                List<Integer> temp2 = map.get(cities.get(i).get(1));
                temp2.add(cities.get(i).get(0));
            }else{
                List<Integer> values = new ArrayList<>();
                values.add(cities.get(i).get(0));
                map.put(cities.get(i).get(1), values);
            }
        }


        //System.out.println(map);
        int node = 0;
        List<Integer> nodes = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            //System.out.println(i + " " + map.get(i));
            if(map.get(i) != null && map.get(i).size() > 0 && visited[i] == 0){
                nodes.add(dfs(map, i, visited));
            }else if(map.get(i) == null || map.get(i).size() == 0){
                nodes.add(1);
            }
        }
        //System.out.println(nodes);
        long ans = 0;
        for(int i = 0; i < nodes.size(); i++){
            ans = ans + Math.min((nodes.get(i) - 1)*c_road + c_lib, nodes.get(i)*c_lib);
        }


        //System.out.println(map);
        return ans;
    }

    public static int dfs(Map<Integer, List<Integer>> map, int startIndex, int[] visited){
        //node++;
        int ans = 0;
        if(visited[startIndex] == 0){
            ans = 1;
            visited[startIndex] = 1;
            for(int element : map.get(startIndex)){
                if(visited[element] == 0){
                    ans = ans + dfs(map, element, visited);
                }
            }
        }
        return ans;
    }

}
