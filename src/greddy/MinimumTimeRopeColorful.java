package greddy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color
 * of the ith balloon. Alice wants the rope to be colorful. She does not want two consecutive balloons
 * to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful.
 * You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs
 * to remove the ith balloon from the rope.
 * Return the minimum time Bob needs to make the rope colorful.
 * Example:
 * Input: colors = "aabaa", neededTime = [1,2,3,4,1]
 * Output: 2
 * Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
 * There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
 * */

public class MinimumTimeRopeColorful {

    public static int minCostTwoPointers(String colors, int[] neededTime) {
        int left=0, right=0, sum = 0;
        char c = colors.charAt(0);
        int currTotal = 0;
        int currMax = 0;
        while(right < colors.length()){
            if(colors.charAt(right) == c){
                currMax = Math.max(currMax, neededTime[right]);
                currTotal += neededTime[right];
            }else{
                c = colors.charAt(right);
                sum += currTotal - currMax;
                currMax=neededTime[right];
                currTotal=neededTime[right];
                left = right;
            }
            right++;
        }
            if(left < right){
                sum += currTotal - currMax;
            }
        return sum;
    }
    public static int minCost(String colors, int[] neededTime) {
        int sum= 0;
        List<Integer> remove = new ArrayList<>();
        char c = colors.charAt(0);
        for(int i=0; i< colors.length(); i++){
            if(colors.charAt(i) == c){
                remove.add(neededTime[i]);
            }else{
                c = colors.charAt(i);
                sum +=  remove.stream().sorted().limit(remove.size()-1)
                        .collect(Collectors.summingInt(Integer::intValue));
                remove.clear();
                remove.add(neededTime[i]);
            }
        }
        if(remove.size() >1){
            sum +=  remove.stream().sorted().limit(remove.size()-1)
                    .collect(Collectors.summingInt(Integer::intValue));
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] neededTime5 = new int[]{1,5,1,7,5,3,5,5,1,1,1};
        System.out.println(minCostTwoPointers("aaabbbabbbb", neededTime5));

        int[] neededTime4 = new int[]{3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(minCostTwoPointers("aaabbbabbbb", neededTime4));

        int[] neededTime3 = new int[]{1,2,3};
        System.out.println(minCostTwoPointers("abc", neededTime3));

        int[] neededTime1 = new int[]{1,2,3,4,5};
        System.out.println(minCostTwoPointers("abaac", neededTime1));


        int[] neededTime2 = new int[]{1,2,3,4,1};
        System.out.println(minCostTwoPointers("aabaa", neededTime2));


        int[] neededTime11 = new int[]{1,2,3,4,1};
        System.out.println(minCost("aabaa", neededTime11));




    }
}
