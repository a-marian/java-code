package dypro.slidingwindow;
/**
 * 209. Minimum Size Subarray Sum
 * Given an array of positive integers nums and a positive integer target, return the minimal
 * length of a subArray whose sum is greater than or equal to target.
 * If there is no such subArray, return 0 instead.
 * Example:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *  */
public class MinimumSizeArray {
    public int minSubArrayLen(int target, int[] nums) {
        if(target == 0) return 0;
        int result = nums.length +1, pointer = 0;
        int max_sum = 0;

        for(int i=0; i < nums.length; i++){
            max_sum += nums[i];
            while(max_sum >= target){
                result = Math.min(result, i-pointer+1);
                max_sum -= nums[pointer++];
            }
        }
        return (result == nums.length+1)? 0:result;
    }
}
