package abcde.classes;

import java.util.Arrays;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int H) {
        int left = 1, right =Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = (left + right) / 2, total = 0;
            for (int p : piles) total += (p + mid - 1) / mid;
            if (total > H) left = mid + 1; else right = mid;
        }
        return left;
    }


    public boolean checkMinimum(int[]piles, int h, int k){
        int time = 0;
        for(int p: piles){
            time += (p-1)/k+1;

            if(time > h) break;
        }
        return time <= h;
    }

    public static void main(String[] args) {
        int [] arr = {30,11,23,4,20};
        int H=6;
        int ans= minEatingSpeed(arr,H);
        System.out.println(ans);
    }
}