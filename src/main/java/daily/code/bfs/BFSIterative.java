package bfs;

import java.util.*;
import java.util.List;

public class BFSIterative {
    public static void BFS(Graph graph, int v, boolean[] discovered){
        //create a queue for doing BFS
        Queue<Integer> queuey = new ArrayDeque<>();
        //mark the source vertex as discovered
        discovered[v] = true;
        //enqueue source vertex
        queuey.add(v);
        //loop till queue is empty
        while (!queuey.isEmpty()){
            //dequeue front node and print it
            v = queuey.poll();
            System.out.print(v + " ");
            //do for every edge(v, u)
            for (int u: graph.adjList.get(v)) {
                if(!discovered[u]){
                    //mark it as discovered and enqueue it
                    discovered[u] = true;
                    queuey.add(u);
                }
            }
        }
    }

    public static void main(String[] args) {
        //List of graph edges  as per the above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1,2), new Edge(1,3),
                new Edge(1,4), new Edge(2,5), new Edge(4, 7),
                new Edge(4,8), new Edge(7, 11), new Edge(7, 12));

        //total number of nodes in the graph (labelled from 0 to 14
        int n = 15;

        //build a graph from the given edges
        Graph graph = new Graph(edges, n);

        //to keep track of whether a vertexes discovered or not
        boolean[] discovered = new boolean[n];

        //perform BFS traversal from all undiscovered nodes to cover all connected components of a graph
        for (int i = 0; i < n; i++) {
            if(discovered[i] == false){
                //start BFS traversal from vertex 'i'
                BFS(graph, i, discovered);
            }
        }
    }
}
