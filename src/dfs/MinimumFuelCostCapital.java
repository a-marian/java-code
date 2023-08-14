package dfs;

import java.util.ArrayList;
import java.util.List;
/**
 * There is a tree (i.e., a connected, undirected graph with no cycles) structure country network
 * consisting of n cities numbered from 0 to n - 1 and exactly n - 1 roads.
 * The capital city is city 0. You are given a 2D integer array roads
 * where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.
 * There is a meeting for the representatives of each city. The meeting is in the capital city.
 * There is a car in each city. You are given an integer seats that indicates the number of seats in each car.
 * A representative can use the car in their city to travel or change the car and ride with another representative.
 * The cost of traveling between two cities is one liter of fuel.
 * Return the minimum number of liters of fuel to reach the capital city.
 * Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * Output: 7
 * */
public class MinimumFuelCostCapital {

        long ans = 0;

        public long minimumFuelCost(int[][] roads, int seats) {

            List<List<Integer>> graph = new ArrayList<>();
            int n = roads.length + 1;

            for(int i= 0; i<n; i++)
                graph.add(new ArrayList<>());

            for(int[] road : roads){
                graph.get(road[0]).add(road[1]);
                graph.get(road[1]).add(road[0]);
            }

            dfs(0, 0, seats, graph);
            return ans;
        }

        private int dfs(int cur, int prev, int seats, List<List<Integer>> graph){
            int representants = 1;
            for(int next: graph.get(cur)){
                if(next == prev)
                    continue;
                representants += dfs(next, cur, seats, graph);
            }
            if(cur != 0)
                ans += (representants + seats-1)/seats;
            return representants;
        }

}
