package dypro;
/***
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least
 * two whose elements sum up to a multiple of k, or false otherwise.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 * Example 1:
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 * ***/

public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {

        int left=0, right=0;
        int nlength = nums.length;
        int sumup = nums[left];
        while(right++ < nlength-1){
            int val = nums[left] + nums[right];
            sumup += nums[right];
            if ( (val % k == 0) || (sumup % k == 0)){
                return true;
            }
            int j =right;
            while(j > 1 && nums[right] > k){
                if((nums[right] -nums[j-2]) % k == 0){
                    return true;
                }
                j--;
            }
        }
        return false;
    }

    public static boolean checkSubarraySumPrefix(int[] nums, int k) {
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == 0 && nums[i-1] == 0) return true;
        }

        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
            if(nums[i] % k ==0) return true;
            int j = i;
            while(j> 1 && nums[i] > k) {
                if((nums[i] - nums[j-2]) % k ==0) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }

    /**
     *     public boolean checkSubarraySumHashMap(int[] nums, int k) {
     *         // initialize the hash map with index 0 for sum 0
     *         Map<Integer, Integer> hashMap = new HashMap<>(Map.of(0, 0));
     *         int sum = 0;
     *         for (int i = 0; i < nums.length; i++) {
     *             sum += nums[i];
     *             // if the remainder sum % k occurs for the first time
     *             if (!hashMap.containsKey(sum % k))
     *                 hashMap.put(sum % k, i + 1);
     *                 // if the subarray size is at least two
     *             else if (hashMap.get(sum % k) < i)
     *                 return true;
     *         }
     *         return false;
     *     }
     * */

    public static void main(String[] args) {

        int[] nums33 = new int[]{1,0,1,0,1};
        int k33 = 4;
        System.out.println(checkSubarraySum(nums33, k33)); //false

        int[] nums11 = new int[]{1,3,6,0,9,6,9};
        int k11 = 7;
        System.out.println(checkSubarraySum(nums11, k11)); //true

         nums11 = new int[]{1,0};
         k11 = 2;
        System.out.println(checkSubarraySum(nums11, k11));//false

        int[] nums1 = new int[]{23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums1, k));//true

        int[] nums = new int[]{23,2,6,4,7};
        k = 13;
        System.out.println(checkSubarraySum(nums, k));//false

        int[] nums2 = new int[]{24,2,4,6,6};
        k = 7;
        System.out.println(checkSubarraySum(nums2, k)); //true
    }
}
