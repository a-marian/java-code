package daily.Y2025.agost;
/**
 * https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers/?envType=daily-question&envId=2025-08-12
 *
 * */
public class NumbersOfWays {

    static final int MOD= 1_000_000_007;
    public static void main(String[] args) {
        numberOfWays(10,2);
    }


    public static int numberOfWays(int n, int x) {
        long[] dp= new long[n+1];
        dp[0]=1;
        for(int i=1; i <=n; i++){
                int val =(int) Math.pow(i,x);
                if(val > n){
                    break;
                }
                for(int j=n; j>=val; j--){
                    dp[j] = (dp[j] + dp[j-val]) % MOD;
                }
            }
            return (int)dp[n];
        }

}
