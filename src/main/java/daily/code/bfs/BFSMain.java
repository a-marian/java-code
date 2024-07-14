package bfs;

import java.util.ArrayList;
import java.util.List;

public class BFSMain {
}

//A class to store a graph edge
class Edge{
    int source, dest;

    Edge(int source, int dest){
        this.source = source;
        this.dest = dest;
    }
}

//A class to represent a graph object
class Graph{
    //A list of lists to represent an adjacent list
    List<List<Integer>> adjList = null;

    //constructor
    Graph(List<Edge> edges, int n){
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        //add edges to the undirected graph
        for (Edge edge:edges) {
            int src = edge.source;
            int dest = edge.dest;
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

