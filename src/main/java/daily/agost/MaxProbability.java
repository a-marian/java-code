package daily.agost;

import java.util.*;

public class MaxProbability {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            // Initialize the adjacency list
            Map<Integer, List<double[]>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
            }

            // Build the graph with the edges and corresponding success probabilities
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                double prob = succProb[i];
                graph.get(u).add(new double[]{v, prob});
                graph.get(v).add(new double[]{u, prob});
            }

            // Array to store the maximum probability to reach each node
            double[] maxProb = new double[n];
            maxProb[start] = 1.0;

            // Priority queue to process nodes in order of max probability
            PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
            pq.add(new double[]{start, 1.0});

            while (!pq.isEmpty()) {
                double[] cur = pq.poll();
                int curNode = (int) cur[0];
                double curProb = cur[1];

                // If we reached the end node, return the probability
                if (curNode == end) {
                    return curProb;
                }

                // Explore neighbors
                for (double[] neighbor : graph.get(curNode)) {
                    int nextNode = (int) neighbor[0];
                    double edgeProb = neighbor[1];

                    // Calculate new probability
                    double newProb = curProb * edgeProb;

                    // If the new probability is higher than the previously recorded one, update it
                    if (newProb > maxProb[nextNode]) {
                        maxProb[nextNode] = newProb;
                        pq.add(new double[]{nextNode, newProb});
                    }
                }
            }

            // If we can't reach the end node, return 0.0
            return 0.0;
        }

        public static void main(String[] args) {
            MaxProbability solution = new MaxProbability();
            int n = 3;
            int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
            double[] succProb = {0.5, 0.5, 0.2};
            int start = 0;
            int end = 2;
            System.out.println(solution.maxProbability(n, edges, succProb, start, end)); // Output: 0.25
        }
    }