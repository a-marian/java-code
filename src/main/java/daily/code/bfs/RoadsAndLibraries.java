package bfs;

import java.util.*;

public class RoadsAndLibraries {

    public static void main(String[] args) {
        int n = 3;
        int c_lib= 2, c_road = 1;
        List<List<Integer>> cities = new ArrayList<>();
        List<Integer> city1 = Arrays.asList(1,2);
        List<Integer> city2 = Arrays.asList(3, 1);
        List<Integer> city3 = Arrays.asList(2, 3);
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        System.out.println(roadsAndLibraries(n, c_lib, c_road, cities));
    }

    //solved by BFS
    public static long roadsAndLibraries(int n, int c_lib,
                                         int c_road, List<List<Integer>> cities) {
        // Write your code here
        if(c_lib <= c_road) return (long)n * (long)c_lib;
        Map<Integer, List<Integer>> graph = buildGraph(cities);
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);

        Queue<Integer> queuey = new LinkedList<>();
        long totalCost = 0;

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                totalCost += c_lib;
                visited[i] = true;
                queuey.offer(i);
                while (!queuey.isEmpty()) {
                    Integer city = queuey.poll();
                    if(city != null && graph.get(city) != null){
                        for (Integer other : graph.get(city)) {
                            if(!visited[other]){
                                totalCost += c_road;
                                queuey.add(other);
                                visited[other] = true;
                            }
                        }
                    }
                }
            }
        }
        return totalCost;
    }
    public static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> cities){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (List<Integer>pairs: cities) {
            graph.put(pairs.get(0), new ArrayList<>());
            graph.put(pairs.get(1), new ArrayList<>());
        }

        for (List<Integer> list : cities) {
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));
        }

        return graph;
    }

}
