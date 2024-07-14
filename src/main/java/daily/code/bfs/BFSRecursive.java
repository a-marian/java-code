package bfs;

import java.util.*;

public class BFSRecursive {

    public static void recursiveBFS(Graph graph, Queue<Integer>q, boolean[]discovered){
        if(q.isEmpty()){
            return;
        }
        //dequeue front node and  print
        int v = q.poll();
        System.out.print(v + " ");
        //do for every edge (v, u)
        for (int u:graph.adjList.get(v)) {
            if(!discovered[u]){
                //mark is as discovered and enqueue it
                discovered[u] = true;
                q.add(u);
            }
        }
        recursiveBFS(graph, q, discovered);
    }

    public static void main(String[] args) {
        //list of graph edges as per  the above diagram
        List<Edge>edges = Arrays.asList(
                new Edge(1,2), new Edge(1,3), new Edge(1,4),
                new Edge(2,5), new Edge(2,6), new Edge(5,9),
                new Edge(4,8), new Edge(7,11), new Edge(7, 12)
        );

        //total number of nodes in the graph(labelled) from 0 to 14)
        int n = 15;

        //build a graph from the given edges
        Graph graph = new Graph(edges, n);
        //to keep track of wheter a vertex is discovered or not
        boolean[]discovered = new boolean[n];

        //create a queue for doing BFS
        Queue<Integer>q = new ArrayDeque<>();

        //perform BFS traversal from all undiscovered nodes to cover all connected components of a graph
        for (int i = 0; i < n; i++) {
            if(discovered[i] == false){
                //mark the source vertex as discovered
                discovered[i] = true;
                //enqueue source vertex as discovered
                q.add(i);
                //start BFS traversal from vertex i
                recursiveBFS(graph, q, discovered);
            }
        }

    }
}
