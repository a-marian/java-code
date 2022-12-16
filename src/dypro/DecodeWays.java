package dypro;

/**
 * 91. Decode Ways
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
 * the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * */

import java.util.Arrays;

public class DecodeWays {

    public static int numDecodings(String s) {
        int size = s.length();

        if (size == 0 || s.charAt(0) == '0') return 0;

        int[]dp = new int[size+2];
        Arrays.fill(dp,1);
        int i=size-1;

        dp[i] = s.charAt(i) == '0'?0:1;

        for ( i = i-1; i >= 0 ; i--) {
            if(s.charAt(i) == '0'){
                // if current digit is '0', so no mater what right is, current ways should be 0;
                dp[i]=0;
            }else {
                // if current digit is not '0', current ways should be ways[i+1]
                // because, for example s="12", i=0, ways[1]=1, then because current digit is not zero, so for
                // each situation of when i=1, the current i=0 should  be a valid way,
                dp[i] = dp[i+1];
                //check is current digit with right 1 digit can be a valid situation,
                // so in this situation only s.charAt(i)=='1'|| s.charAt(i)=='2' and s.charAt(i+2)<= '6'
                // can be valid situation, the ways[i] should + dp[i+2]:
                if(i+2 < dp.length && s.charAt(i)=='1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6'){
                    dp[i]+=dp[i+2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println( numDecodings("11106"));
        System.out.println( numDecodings("111010"));
        System.out.println( numDecodings("1234"));
    }

}
/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * https://leetcode.com/problems/decode-ways/
 * */
