package greddy;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSubsequence {

    public static int numberOfArithmeticSlicesI(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }

    public static int numberOfArithmeticSlicesII(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[n];
        for(int i=0; i < n; i++){
            cnt[i] = new HashMap<>(i);
            for(int j=0; j <i; j++){
                long delta = (long)nums[i]-(long)nums[j];
                if(delta< Integer.MIN_VALUE || delta > Integer.MAX_VALUE){
                    continue;
                }
                int diff=(int)delta;
                int sum = cnt[i].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin+sum+1);
                ans+=sum;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,4,6,8,10}; // 7
        System.out.println(numberOfArithmeticSlicesII(nums));
    }

}
