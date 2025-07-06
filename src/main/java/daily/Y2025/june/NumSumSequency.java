package daily.Y2025.june;

import java.util.Arrays;

public class NumSumSequency {

    public static void main(String[] args) {
        int []  nums = new int[]{2,3,3,4,6,7};
        System.out.println(numSubSeq(nums, 7));
        System.out.println(numSubSeq(nums, 12));

    }

        public static int numSubSeq(int[] nums, int target) {
            int a = nums.length;
            int mod = 1_000_000_007;
            Arrays.sort(nums);

            int[] power = new int[a];
            power[0] = 1;
            for(int i =1; i < a; ++i){
                power[i] = (power[i-1]*2) % mod;
            }

            int answer = 0;
            int left = 0, right = a-1;

            while(left <= right){
                if(nums[left]+ nums[right] <= target){
                    answer += power[right -left];
                    answer %= mod;
                    left++;
                } else {
                    right--;
                }
            }
            return answer;
        }

}
