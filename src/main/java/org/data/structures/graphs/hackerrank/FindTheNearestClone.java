package org.data.structures.graphs.hackerrank;

import java.io.*;
import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class FindTheNearestClone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        //Prepare adjacent list
        List<Integer>[] map = new ArrayList[graphNodes + 1];
        Map<Integer, Integer> distances = new HashMap<>();

        for(int i = 1; i <= graphNodes; i++)
            map[i] = new ArrayList<Integer>();

        for(int i = 0; i < graphFrom.length; i++){
            map[graphFrom[i]].add(graphTo[i]);
            map[graphTo[i]].add(graphFrom[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graphNodes + 1];
        for(int i = 0; i < ids.length; i++){
            if(ids[i] == val){
                queue.add(i+1);
                distances.put(i+1, 0);
            }
        }

        if(queue.size() < 2){
            return -1;
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result = new ArrayList<>();
            int current = queue.poll();
            visited[current] = 1;

            for(int e : map[current]){
                if(distances.containsKey(e) && visited[e] == 0){
                    //return distances.get(e) + distances.get(current) + 1;
                    result.add(distances.get(e) + distances.get(current) + 1);

                }else{
                    queue.add(e);
                    distances.put(e, distances.get(current) + 1);
                }
            }
            if(result.size() > 0){
                return result.stream().mapToInt(v -> v).min().getAsInt();
            }

        }
        //System.out.println(result);

        return -1;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

