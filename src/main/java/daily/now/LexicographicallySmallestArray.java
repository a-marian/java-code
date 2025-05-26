package daily.now;

import java.util.*;
import java.util.stream.Collectors;

public class LexicographicallySmallestArray {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;

            class Pair {
                int index, value;
                Pair(int index, int value) {
                    this.index = index;
                    this.value = value;
                }
            }

            Pair[] pairs = new Pair[n];
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair(i, nums[i]);
            }

            Arrays.sort(pairs, (a, b) -> a.value - b.value);
            Pair[] ids = Arrays.copyOf(pairs, n);

            int i = 0;
            while (i < n) {
                int j = i;
                i++;

                while (i < n && pairs[i].value - pairs[i - 1].value <= limit) {
                    i++;
                }

                Arrays.sort(ids, j, i, (a, b) -> a.index - b.index);

                for (int k = j; k < i; k++) {
                    ans[ids[k].index] = pairs[k].value;
                }
            }

            return ans;
        }

    public int[] lexicographicallySmallestArrayGreedy(int[] nums, int limit) {
        List<Deque<Integer>> groups = new ArrayList<>(); // list of queues
        Map<Integer, Integer> numToGroup = new HashMap<>(); // map nums[i] -> group

        //Sort the numberss and organize them into groups
        List<Integer> sortedNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(sortedNums);

        for(int n: sortedNums){
            if(groups.isEmpty() || Math.abs(n- groups.get(groups.size() -1).getLast()) > limit){
                groups.add(new ArrayDeque<>());
            }
            groups.get(groups.size() -1).add(n);
            numToGroup.put(n, groups.size()-1);
        }

        //Construct the result array
        int len = nums.length;
        int[] res = new int[len];
        for(int i=0; i < len; i++ ){
            int groupIndex = numToGroup.get(nums[i]);
            res[i] = (groups.get(groupIndex).pollFirst());
        }
        return res;
    }

}