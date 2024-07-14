package daily.code.dypro;

public class StudentAttendanceRecordII {

    /***
     *  static final int MOD = 1000000007;
     *
     *     public int checkRecord(int n) {
     * long[] endingPL = new long[n + 1]; // ending with P or L, no A
     *     long[] endingP = new long[n + 1]; // ending with P, no A
     *     endingPL[0] = endingP[0] = 1;
     *     endingPL[1] = 2;
     *     endingP[1] = 1;
     *
     *     for (int i = 2; i <= n; i++) {
     *         endingP[i] = endingPL[i - 1];
     *         endingPL[i] = (endingP[i] + endingP[i - 1] + endingP[i - 2]) % MOD;
     *     }
     *
     *     long result = endingPL[n];
     *     for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
     *         long sum = (endingPL[i] * endingPL[n - i - 1]) % MOD;
     *         result = (result + sum) % MOD;
     *     }
     *
     *     return (int) result;
     *     }
     */

    private static int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        //max absences
        int rows= 2;
        int cols = 3;
        int[][] dp = new int [rows][cols];
        //first day present
        dp[0][0] = 1;
        //first day absent
        dp[1][0] = 1;
        // first day late
        dp[0][1] = 1;

        for(int i =2; i <= n; i++){
            int[][] newDP = new int[rows][cols];
            for(int row=0; row < rows; row++){
                for(int col = 0; col < cols; col++){
                    int val = dp[row][col];
                    newDP[row][0] = (newDP[row][0]+ val)% MOD;
                    if(row == 0){
                        newDP[row+1][0]= (newDP[row+1][0]+ val) % MOD;
                    }
                    if(col < 2){
                        newDP[row][col+1]= (newDP[row][col+1]+ val) % MOD;
                    }
                }
            }
            dp = newDP;
        }

        int total = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                total = (total + dp[row][col]) % MOD;
            }
        }
        return total;
    }


}
