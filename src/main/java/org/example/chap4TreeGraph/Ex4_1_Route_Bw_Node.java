package org.example.chap4TreeGraph;

import java.util.Deque;
import java.util.LinkedList;

/*
https://www.geeksforgeeks.org/dsa/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/
 */
public class Ex4_1_Route_Bw_Node {

    static boolean dfs(int[][] adj, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(int nextNode: adj[src]){
            if(!visited[nextNode]){
                visited[nextNode] = true;
                if(dfs(adj, nextNode, dest, visited))
                    return true;
            }
        }

        return false;
    }

    static boolean bfs(int[][] adj, int src, int dest, boolean[] visited){
        if(src == dest){
            return true;
        }

        Deque<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.addLast(src);

        while(!queue.isEmpty()){
            int node = queue.pollFirst();
            // for every child
            for(int nextNode: adj[node]){
                // if not is not visited
                if(!visited[nextNode]){
                    queue.addLast(nextNode);
                    visited[nextNode] = true;
                    if(nextNode == dest){
                        return true;
                    }
                }

            }
        }

        return false;
    }

    static boolean isReachable(int[][] adj, int src, int dest) {
        int n = adj.length;

        // Create a vector to keep track of visited vertices
        boolean[] visited = new boolean[n];

//        // Call the DFS utility function
//        return dfs(adj, src, dest, visited);

        // Call the BFS utility function
        return bfs(adj, src, dest, visited);
    }

    public static void main(String[] args) {
        int[][] adj = {
                {},
                {0, 2},
                {0, 3},
                {},
                {2}
        };
        int src = 1, dest = 3;
        if (isReachable(adj, src, dest)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
