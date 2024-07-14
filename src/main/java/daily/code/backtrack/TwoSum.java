package backtrack;

import java.util.HashMap;

/**
 * Problem
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].*/

public class TwoSum {
    private static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(num1 + nums[j] == target){
                    return  new int[]{i, j};
                }
            }
        }
        return new int[]{0,0};

    }
  // 9 - 7 = 2
  // 9 - 2 = 7
    private static int[] twoSumOptimus(int[] nums, int target){
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (memo.containsKey(target-nums[i])){
                return new int[]{memo.get(target-nums[i]), i};
            }
            memo.put(nums[i], i);
        }
        return new int[] {0,0};
    }

    public static void main(String[] args) {

        int[] nums= {11,7,2,15};
        int[] res = twoSum(nums, 9);
        int[] res1 = twoSumOptimus(nums, 9);
         System.out.println(res[0] +" "+ res[1]);
        System.out.println(res1[0] +" "+ res1[1]);
    }

}
