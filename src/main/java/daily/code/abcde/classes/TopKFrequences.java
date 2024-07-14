package abcde.classes;

import java.util.*;

public class TopKFrequences {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();


        for(int i=0; i < nums.length; i++){
            if(memo.containsKey(nums[i])){
                memo.put(nums[i], memo.getOrDefault(nums[i],0)+1);
            }
        }

        return  memo.keySet().stream()
                .sorted((a,b) -> b-a)
                .mapToInt(a -> (int)a).limit(k).toArray();
    }


        public int[] topKFrequentBucket(int[] nums, int k) {
            if (k == nums.length) {
                return nums;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int n : nums) {
                if(n < min) min = n;
                if(n > max) max = n;
            }

            int[] aux = new int[max - min + 1];
            for(int n : nums) {
                aux[n - min]++;
            }


            List<Integer>[] bucket = new List[nums.length + 1];
            int maxFreq = 0;
            for(int i = 0; i < aux.length; i++) {
                if(aux[i] > 0) {
                    if(bucket[aux[i]] == null) bucket[aux[i]] = new ArrayList<>();
                    bucket[aux[i]].add(i + min);
                    maxFreq = Math.max(maxFreq, aux[i]);
                }
            }

            int[] res = new int[k];
            int idx = 0;
            for(int i = maxFreq; i >= 0 && idx < k; i--) {
                if(bucket[i] != null) {
                    for(int n : bucket[i]) {
                        if(idx == k) break;
                        res[idx++] = n;
                    }
                }
            }

            return res;
        }

}
