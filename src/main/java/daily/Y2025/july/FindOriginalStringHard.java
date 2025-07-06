package daily.Y2025.july;

import java.util.ArrayList;
import java.util.List;

public class FindOriginalStringHard {

    public int methodtosolve(String word, int k){
        //calculate total count for
        int MOD = 1_000_000_007;
        List<Integer> runs = new ArrayList<>();
        int n = word.length();
        int t=0;
        while(t <n){
            int count=1;
            while(t+1 < n && word.charAt(t) == word.charAt(t+1)){
                count++;
                t++;
            }
            runs.add(count);
        }

        int m= runs.size();
        if(m < k) return 0; // if there are fewer groups than k, no valid is possible
        long[][] dp = new long[m+1][m+1];
        dp[0][0]=1;

        //step 3: fill DP table
        for(int i=0; i < m; i++){
            for(int j=0; j <= i; j++){
                if(dp[t][j] == 0) continue; //skip if no ways for this state
                //don't include the current group
                dp[t+1][j] = (dp[t+1][j] + dp[t][j]) % MOD;
                //include the current group
                dp[t+1][j+1] = (dp[t+1][j+1] + dp[t][j]) % MOD;
            }
        }

        //step 4: sum the number of ways fo length >= k
        long result = 0;
        for(int h= k; h <= m; h++){
            result = (result+ dp[m][h]) % MOD;
        }

        return (int) result;
    }
}
