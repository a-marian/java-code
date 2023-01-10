package greddy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine
 * the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 * */

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]res = new int[nums1.length];
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        for(int i=0; i<nums2.length; i++){
            memo.put(nums2[i],i);
        }
        for(int i=0; i<nums1.length; i++){
            if(i< nums1.length-1 && memo.get(nums1[i]) < nums1.length-1 &&
                    memo.get(nums1[i]+1) > memo.get(nums1[i])){
                res[i]=memo.get(nums1[i]+1);
            }else{
                res[i] = -1;
            }
        }
        return res;
    }
    /**
    * Key observation:
     * Suppose we have a decreasing sequence followed by a greater number
     * For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence
     *
     * We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all
     * elements less than x and for all the popped ones, their next greater element is x
     * For example [9, 8, 7, 3, 2, 1, 6]
     * The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose
     * next greater element should be 6
     * */
    public int[] nextGreaterElementMonotonic(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4,1,2};
        int[] arr2 = new int[]{1,2,3,4};

        nextGreaterElement(arr1, arr2);

    }
}
