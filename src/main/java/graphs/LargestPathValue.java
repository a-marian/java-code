package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestPathValue {

    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges ={{0,1},{0,2},{2,3},{3,4}};
        System.out.println(largestPathValue(colors, edges));
    }

    public static int largestPathValue(String colors, int [][] edges){
        int n = colors.length();
        List<Integer>[] graph =  new List[n];
        int[] inDegrees = new int [n];
        int[][] count = new int [n][26];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            inDegrees[edge[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(inDegrees[i] == 0){
                queue.offer(i);
            }
        }
        
        int visitedCount= 0;
        int maxColorValue= 0;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            visitedCount++;
            count[node][colors.charAt(node)- 'a']++;
            maxColorValue = Math.max(maxColorValue, count[node][colors.charAt(node)-'a']);
            for (int neighbor: graph[node]){
                for (int i = 0; i < 26; i++) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]);
                }
                inDegrees[neighbor]--;
                if(inDegrees[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        return visitedCount == n ? maxColorValue: -1;
    }

}
