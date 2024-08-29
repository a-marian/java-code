package daily.agost;

import java.util.HashMap;
import java.util.Map;

/**
 * 947. Most Stones Removed with Same Row or Column
 * To solve the problem, you can use either a Depth-first Search(DFS) approach or a Union-Find(Disjoint Set Union, DSU)
 * approach. The goal is to determine the maximum number of stones that can be removed such that thre is at least one
 * stone left on either the same row or column for each removed stone.
 *
 * Approach Union-Find(Disjoint Set Union)
 * Union-find concept:
 * * We treat each stone as a node in graph.
 * * Stones on the same row or column are considered connected.
 * * The problem the reduces to finding the number of connected components in the graph. The answer is the total number
 * of stones minus the number of connected components.
 *
 * Implementation:
 * Use a Union-Find data structure to group stones that are in the same row or column.
 * Each stone's rowand column can be though of as a virtual node in the Union-Find struncture. We can use separate keys
 * for rows and columns to avoid conflict.
 * Union-find Operations:
 * find: Find the root of a node.
 * union: Connect two nodes.
 * */
public class RemoveStones {
        // Union-Find helper class
        class UnionFind {
            private Map<Integer, Integer> parent;
            private int count; // number of connected components

            public UnionFind() {
                parent = new HashMap<>();
                count = 0;
            }

            public int find(int x) {
                if (parent.putIfAbsent(x, x) == null) {
                    count++;
                }
                if (x != parent.get(x)) {
                    parent.put(x, find(parent.get(x)));
                }
                return parent.get(x);
            }

            public void union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);
                if (rootX != rootY) {
                    parent.put(rootX, rootY);
                    count--;
                }
            }

            public int getCount() {
                return count;
            }
        }

        public int removeStones(int[][] stones) {
            UnionFind uf = new UnionFind();

            for (int[] stone : stones) {
                // Using (row, ~col) to distinguish row and column
                uf.union(stone[0], ~stone[1]);
            }

            return stones.length - uf.getCount();
        }

        public static void main(String[] args) {
            RemoveStones sol = new RemoveStones();
            int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
            System.out.println(sol.removeStones(stones)); // Output: 5
        }
}

/**
 * Explanation of Code:
 * UnionFind Class: This class handles the Union-Find operations with path compression (find) and union by rank(union).
 * `removeStones` method:
 * * For each stone, perform a union operation for its row and column. To differentiate between row and column,
 *   we use ~stone[1] (bitwise NOT) to make column indices distinct.
 * * The number of connected components (uf.getCount()) gives us the number of isolated groups.
 *   The result is the total number of stones minus the number of these groups.
 *
 * Complexity:
 * Time Complexity: O(N * α(N)), where N is the number of stones and α is the inverse Ackermann function,
 * which grows very slowly.
 * Space Complexity: O(N), for storing parent pointers in the Union-Find structure.
 * This solution efficiently finds the maximum number of stones that can be removed while leaving the grid
 * in the required state.
 * */
