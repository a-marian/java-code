package twopointers;

import static twopointers.CodeUtil.printArray;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * https://leetcode.com/problems/merge-sorted-array/
 * */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1, right = n-1;
        int temp = nums1.length -1;
        while(right >= 0){

            if(left >= 0 && nums1[left] > nums2[right]){
                nums1[temp] = nums1[left];
                temp--;
                left--;
            }else{
                nums1[temp] = nums2[right];
                temp--;
                right--;
            }
        }
    }
    public static void main(String[] args) {
         // Input:
         int[] nums1 = new int[]{1,2,3,0,0,0};
         int[] nums2 = new int[]{2,5,6};
         int m = 3, n = 3;
         merge(nums1, m,nums2,n);
         printArray(nums1);
         // Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
         // The result of the merge should be [1,2,2,3,5,6] with the underlined elements coming from nums1.
         /**
          * Time Complexity
          *
          * **/
    }
}
