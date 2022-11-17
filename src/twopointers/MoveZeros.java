package twopointers;

import static twopointers.CodeUtil.printArray;

/**
 * https://leetcode.com/problems/move-zeroes/
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * */
public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0, right=0, cont = 0;
        while(cont <= len-1){
            if (nums[cont] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
            cont++;
        }
    }

    public static void main(String[] args) {
       int[] nums = new int[]{0,1,0,3,12};
       moveZeroes(nums);
       printArray(nums);
    }
}
