package bfs;
import java.util.*;

public class BFSShortestReachGraph {
    public static class Graph{
        int vertices;
        Map<Integer, List<Integer>> graph;

        public Graph(int vertices){
            this.vertices = vertices;
            graph = new HashMap<>();
        }

        public void addEdge(int u, int v){
            if(!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);
            if(!graph.containsKey(v)){
                graph.put(v, new ArrayList<>());
            }
            graph.get(v).add(u);
        }

        public int[] getShortestReach(int start) {
            Set<Integer> seen = new HashSet<>();
            Deque<Integer> queue = new LinkedList<>();
            int[] result = new int[vertices+1];

            int cur;
            queue.addFirst(start);
            while (!queue.isEmpty()) {
                cur= queue.removeLast();
                if(graph.containsKey(cur)){
                    List<Integer> adjacent = graph.get(cur);
                    for (int adj : adjacent) {
                        if(seen.contains(adj)) continue;
                        result[adj]= result[cur]+6;
                        queue.addFirst(adj);
                        seen.add(adj);
                    }
                }
            }
            for (int i = 1; i <= vertices; i++) {
                if(result[i] == 0) result[i] = -1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.
        Your class should be named Solution. */
        Scanner scanner= new Scanner(System.in);

        int q= scanner.nextInt();
        for(int i=0; i<q; i++){
            int n,m;
            n=scanner.nextInt();
            Graph graph= new Graph(n);

            m=scanner.nextInt();
            for(int j=0; j<m; j++){
                int u,v;
                u= scanner.nextInt(); v= scanner.nextInt();
                graph.addEdge(u,v);
            }

            int start= scanner.nextInt();
            int[] result= graph.getShortestReach(start);

            for (int k=1; k<result.length; k++){
                if(k!=start) System.out.print(""+result[k]+" ");
            }
            System.out.println();
        }
        scanner.close();

    }

}
