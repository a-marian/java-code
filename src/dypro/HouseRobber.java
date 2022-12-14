package dypro;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * Example:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1 ) return nums[0];
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int house1 = 0;
        int house2 = 0;

        for(int i=0; i< len; i++){
            max = Math.max(nums[i] + house1, house2);
            house1 = house2;
            house2 = max;
        }
        return max;
    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * https://leetcode.com/problems/house-robber/
 * */
