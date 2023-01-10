package greddy;

import java.util.*;
import java.util.stream.Collectors;
/**
 * 1657. Determine if Two Strings Are Close
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 * Example 1
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 *
 * */

public class TwoStringClose {


        public boolean closeStringsV1(String word1, String word2) {
            if (word1.length() != word2.length()) return false;
            Map<Character, Integer> memo1 = new HashMap<>();
            Map<Character, Integer> memo2 = new HashMap<>();
            for(int i = 0; i < word1.length(); i++){
                memo1.put(word1.charAt(i), memo1.getOrDefault(word1.charAt(i),0)+1);
                memo2.put(word2.charAt(i), memo2.getOrDefault(word2.charAt(i),0)+1);
            }
            if(!memo1.keySet().equals(memo2.keySet())){
                System.out.println(memo1.keySet());
                return false;
            }

            return  memo1.values().stream().sorted().collect(Collectors.toList())
                    .equals(memo2.values().stream().sorted().collect(Collectors.toList()));

        }

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] letters1 = new int[26];
        int[] letters2 = new int[26];

        //loop through each word
        //add letter to appropriate array
        try {
            byte[] bytes1 = word1.getBytes("US-ASCII");
            byte[] bytes2 = word2.getBytes("US-ASCII");
            for(byte num : bytes1){
                letters1[num-97]++;
            }
            for(byte num : bytes2){
                letters2[num-97]++;
            }
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //check if both arrays have zeros in the same indexes
        for(int i = 0; i < letters1.length; i++){
            if(letters1[i] == 0 && letters2[i] != 0 || letters2[i] == 0 && letters1[i] != 0) return false;
        }

        //sort each array
        Arrays.sort(letters1);
        Arrays.sort(letters2);

        //return if each array is equal
        for(int i = 0; i < letters1.length; i++){
            if(letters1[i] != letters2[i]) return false;
        }
        return true;
    }


}
