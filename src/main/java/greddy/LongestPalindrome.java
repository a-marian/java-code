package greddy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
 */

public class LongestPalindrome {

    public static void main(String[] args) {
        String [] words = {"ab","ty","yt","lc","cl","ab"};
        String [] words2 = {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
        //System.out.println(longestPalindrome(words2));
        System.out.println(longestPalindromeFantastic(words2));
    }
    public static int longestPalindromeFantastic(String[] words) {
        int res = 0;
        int[][] count = new int[26][26];
        for ( final String word : words){
            final int i = word.charAt(0) - 'a';
            final int j = word.charAt(1) - 'a';
            if(count[j][i] > 0){
                res += 4;
                --count[j][i];
            } else {
                ++count[i][j];
            }
        }

        for(int i=0; i < 26; ++i){
            if(count[i][i] > 0){
                return res+2;
            }
        }
        return res;
    }


    public static int longestPalindrome(String[] words) {
            HashMap<String,Integer> memo = new HashMap<>();
            for(int i=0; i< words.length; i++){
                String reverseKey = getReverse(words[i]);
                if (memo.containsKey(reverseKey)){
                    memo.put(reverseKey, memo.get(reverseKey)+1);
                    continue;
                }
                if (!memo.containsKey(words[i])){
                    memo.put(words[i], 1);
                }
            }
            int result=0, odd= 0;
            for(Map.Entry<String, Integer> entry: memo.entrySet()){
                if(entry.getValue() == 1){
                    if(entry.getKey().charAt(0) == entry.getKey().charAt(1)){
                        odd = 2;
                    }
                }else{
                    result += entry.getValue()*2;
                }
            }

            return result + odd;
        }
        private static String getReverse(String word){
            return new StringBuilder(word).reverse().toString();
        }

}
