package org.data.structures.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

    public static void main(String[] args) {
        int[][] graph = {{0,0,0,0,0,0,0},
                         {0,0,1,1,0,0,0},
                         {0,1,0,0,1,0,0},
                         {0,1,0,0,1,0,0},
                         {0,0,1,1,0,1,1},
                         {0,0,0,0,1,0,0},
                         {0,0,0,0,1,0,0}};
        int[] visisted = new int[graph.length];
        // BFS Traversal
        GraphTraversal obj = new GraphTraversal();
        //obj.BFS(graph, 6, visisted);
        obj.DFS(graph, 4, visisted);
    }

    /**
     * Breadth first search
     * Time complexity O(n^2)
     * @param graph
     * @param startVertex
     * @param visited
     */
    public void BFS(int[][] graph, int startVertex, int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        int j = graph[0].length;
        visited[startVertex] = 1;
        while(!queue.isEmpty()){
            int i = queue.poll();
            System.out.print(i + " ");
            for(int k = 1; k < j; k++){
                if(graph[i][k] == 1 && visited[k] == 0){
                    visited[k] = 1;
                    queue.add(k);
                }
            }
        }
    }

    /**
     * Depth first search
     *
     * @param graph
     * @param startVertex
     */
    public void DFS(int[][] graph, int startVertex, int[] visited){
        if(visited[startVertex] == 0){
            visited[startVertex] = 1;
            System.out.print(startVertex + " ");
            for(int k = 1; k < graph[0].length; k++){
                if(graph[startVertex][k] == 1 && visited[k] == 0){
                    DFS(graph, k, visited);
                }
            }
        }
    }
}
