package daily.agost;

import java.util.HashMap;

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


        int answer =0;
        HashMap<Integer, Integer> set = new HashMap();

        public int removeStones(int[][] stones) {
            for (int i=0; i < stones.length; ++i){
                removeStonesDFS(stones[i][0], ~stones[i][1]);
            }
            return stones.length - answer;
        }

        private int find(int x){
            if(set.putIfAbsent(x, x) == null)
                answer++;
            if(x != set.get(x))
                set.put(x, find(set.get(x)));
            return set.get(x);
        }

        private void removeStonesDFS(int x, int y){
            x = find(x);
            y = find(y);
            if(x != y){
                set.put(x, y);
                answer--;
            }
        }


}
