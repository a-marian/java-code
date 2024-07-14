package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    public int numSquaresDP(int n) {
        int[]dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i = 0; i <= n; i++){
            for(int j =1; j*j <= i; j++){
                dp[i]=Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public int numSquaresBFS(int n){
        int sqrRoot = (int) Math.sqrt(n), level =0;
        boolean[] visited = new boolean[n];
        int[]perfectSquare = new int[sqrRoot];

        for(int i=1; i<=sqrRoot; ++i) perfectSquare[i-1] = i*i;

        //starting with  the number
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()){
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int pSquare: perfectSquare) {
                    int remain = num - pSquare;
                    if (remain == 0){
                        return level;
                    } else if ( remain > 0 && !visited[remain-1]) {
                        visited[remain-1] = true;
                        queue.offer(remain);
                    } else if (remain < 0) {
                        break;
                    }
                }
            }
        }
        return 0;
    }
}
