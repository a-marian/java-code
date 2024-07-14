package bfs;

import java.util.*;

/**
 * Return all non-negative integers of length n such that the absolute difference
 * between every two consecutive digits is k.
 * Note that every number in the answer must not have leading zeros.
 * For example, 01 has one leading zero and is invalid.
 * */

public class NumbersWithSameConsecutiveDiffs {

    public int[] numSameConsecDiffFast(int n, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 9; i++)
            backtrack(set, i, i, 1, n, k);
        int[] res = new int[set.size()];
        int j = 0;
        for (int num : set)
            res[j++] = num;
        return res;
    }

    public void backtrack(Set<Integer> set, int num, int last, int len, int n, int k) {
        if (len == n) {
            set.add(num);
            return;
        }
        if (last + k <= 9)
            backtrack(set, num * 10 + last + k, last + k, len + 1, n, k);
        if (last - k >= 0)
            backtrack(set, num * 10 + last - k, last - k, len + 1, n, k);
    }

    public int[] numsSameConsecDiff(int n, int k) {
        if(n == 1) return new int[]{k};

        List<Integer> list = new ArrayList<Integer>();
        int min = (int)Math.pow(10, n-1);

        for(int i=1; i< 10; i++){
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(i);

            while(!q.isEmpty()){
                int num = q.poll();
                if(num >= min){
                    list.add(num);
                    continue;
                }
                int x = num%10;
                if(k > 0 && x -k >= 0)
                    q.add(num*10 + x - k);
                if(x+k < 10)
                    q.add((num*10)+x+k);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
