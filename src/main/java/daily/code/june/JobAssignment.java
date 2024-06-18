package daily.code.june;

import java.util.Arrays;

public class JobAssignment {

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Create a 2D array to hold job difficulty and profit
        int[][] jobs = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty, and by profit descending if difficulties are the same
        Arrays.sort(jobs, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);

        // Sort worker array
        Arrays.sort(worker);

        int maxProfit = 0;
        int best = 0; // To track the best profit we can get for a given difficulty
        int jobIndex = 0;

        // Iterate over each worker
        for (int w : worker) {
            // Update the best profit we can get for the current worker's ability
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= w) {
                best = Math.max(best, jobs[jobIndex][1]);
                jobIndex++;
            }
            // Add the best profit we can get to the total profit
            maxProfit += best;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};

        System.out.println(maxProfitAssignment(difficulty, profit, worker)); // Output should be 100
    }
}

