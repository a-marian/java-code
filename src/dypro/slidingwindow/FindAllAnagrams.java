package dypro.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Given two dypro.strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * */
public class FindAllAnagrams {
        public static List<Integer> findAnagramsV2(String s, String p) {
            int CHARACTERS = 26;
            int k = p.length();
            char[] sArray = new char[CHARACTERS];
            char[] pArray = new char[CHARACTERS];
            for (int i = 0; i < p.length(); i++) {
                pArray[p.charAt(i) -'a']++;
            }
            int right = 0;
            int left = 0;
            List<Integer> list = new ArrayList<>();
            while (left < s.length()) {
                sArray[s.charAt(left) -'a']++;
                if (left - right + 1 >= k) {
                    if (Arrays.equals(pArray, sArray))
                        list.add(right);
                    sArray[s.charAt(right) -'a']--;
                    right++;
                }
                left++;
            }
            return list;
        }

    public static void main(String[] args) {
        System.out.println(findAnagramsV2("cbaebabacd", "abc"));

        System.out.println(findAnagramsV2("abab", "ab"));

    }

}
/***
 * N = s length
 * Time complexity O(N)
 * Space complexity O(N)
 */
