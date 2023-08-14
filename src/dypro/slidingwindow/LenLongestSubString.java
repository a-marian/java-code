package dypro.slidingwindow;

import java.util.HashSet;
import java.util.Set;
/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * */

public class LenLongestSubString {

    public static int lengthOfLongestSubstringFast(String s) {
        if(s.length() <= 1) return s.length();

        char[] sarr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0, right=0;
        while(right < s.length()){
            if(!set.contains(sarr[right])){
                set.add(sarr[right++]);
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(sarr[left++]);
            }
        }
        return maxLength;
    }

    public static int lenLongestSubStringFaster(String s){
        if(s.length() <= 1) return  s.length();

        int left= 0, right=0, max = 0;
        char c = s.charAt(0);
        while(right < s.length()){

            if(s.substring(left, right).contains(String.valueOf(c))){
                c = s.charAt(left++);
            }else{
                c = s.charAt(right);
                max = Math.max(max, s.substring(left, right).length());
            }
            right++;
        }
        return max;
    }

    public static int lenLongestSubString(String s){
        if (s.length() <=1) return s.length();

        int left= 0, right=0, max = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }else{
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        System.out.println(lenLongestSubStringFaster("pwwkew"));
       // System.out.println(System.currentTimeMillis() - start);

        System.out.println(lenLongestSubString("pwwkew"));

        System.out.println(lenLongestSubString("abcabcbb"));

        System.out.println(lengthOfLongestSubstringFast("bbbbbb"));


    }

}
