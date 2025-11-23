package daily.Y2025.november;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 * 1262. Greatest Sum Divisible by Three
 * */
public class MaxSumDivThree {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4};
        System.out.println(maxSumDivThree(nums));
    }
    public static int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for(int num: nums){
            int[] temp = dp.clone();
            for(int r= 0; r < 3; r++){
                int newR = (r + num) % 3;
                temp[newR] = Math.max(temp[newR], dp[r]+num);
            }
            dp = temp;
        }
        return dp[0];
    }



}
