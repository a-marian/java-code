package greddy;

import java.util.HashMap;

/**
 *
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order.
 * Each element can be selected at most once.
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 * A palindrome is a string that reads the same forward and backward.*/
public class LongestPalindromeConcatening {

    public int longestPalindromeME(String[] words) {
        int ans = 0;
        int[][]freq = new int[128][128];
        for(String w: words)
            freq[w.charAt(0)][w.charAt(1)]++;
        int even = 0;
        boolean odd=false;
        for(int i=0; i < 128; i++){
            odd |= (freq[i][i] & 1) == 1;
            even += freq[i][i] / 2;
            for(int j= i+1; j < 128; j++)
                even += Math.min(freq[i][j], freq[j][i]);

        }
        ans = even *2*2;
        if(odd){ ans+=2;}

        return ans;
    }

    public static int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];//array for all alphabet combinations
        for (String word : words)
            freq[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;// here we first increase the freq for every word
        int left = 0;//to store freq counts
        boolean odd = false;
        for (int i = 0; i != 26; i++) {//iterate over our array
            odd |= (freq[i][i] & 1) == 1;//means odd number of freq for similar words are there
            left += freq[i][i] / 2;
            for (int j = i + 1; j != 26; j++)//nested iteration to find non similar pairs
                left += Math.min(freq[i][j], freq[j][i]);//taking min times from both present
        }
        int res = left * 2 * 2;//res from total freq found!!
        if (odd){
            res+=2;// if odd then adding 2
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr1 = new String[]{"lc","cl","gg"};
        String[] arr2 = new String[]{"ab","ty","yt","lc","cl","ab"};
        String[] arr3 = new String[]{"cc", "aa", "xx"};

        //["dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"]
        System.out.println(longestPalindrome(arr3));
    }

}
