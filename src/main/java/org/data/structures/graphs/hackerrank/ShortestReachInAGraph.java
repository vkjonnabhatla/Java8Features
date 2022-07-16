package org.data.structures.graphs.hackerrank;

import java.io.*;
import java.util.*;

public class ShortestReachInAGraph {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int queries = Integer.parseInt(scanner.nextLine());
        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }


        int startNode = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> ans = findShortest(graphNodes, graphEdges, graphFrom, graphTo, startNode);

        bufferedWriter.write("List of Integer: "+ ans);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    public static List<Integer> findShortest(int graphNodes, int graphEdges, int[] graphFrom,int[] graphTo,int startNode){

        List<Integer>[] graph = new ArrayList[graphNodes + 1];
        Map<Integer, Integer> distances = new HashMap<>();

        for(int i = 1; i <= graphNodes; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < graphFrom.length; i++){
            graph[graphFrom[i]].add(graphTo[i]);
            graph[graphTo[i]].add(graphFrom[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graphNodes + 1];
        queue.add(startNode);

        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = 1;

            for(int a : graph[current]){
                if(distances.containsKey(current) && visited[a] == 0){
                    distances.put(a, distances.get(current) + 6);
                }else if(visited[a] == 0){
                    distances.put(a, 6);
                }

                if(visited[a] == 0){
                    queue.add(a);
                }
            }
            // System.out.println(queue);
            //System.out.println(distances);

        }

        for(int i = 1; i < graph.length; i++){
            if(graph[i].size() == 0){
                distances.put(i, -1);
            }
        }
        System.out.println(distances);

        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(distances.values());
        return res;

    }
}
