package dypro.strings;

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number of vowel letters
 * in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * */


public class MaximumNumberVowels {
    public static int maxVowels(String s, int k) {
        int slen = s.length();
        int numVowelsInSubstring = 0;

        for(int i = 0; i < k; i++)
            numVowelsInSubstring += isVowel(s.charAt(i));

        int maxNumVowels = numVowelsInSubstring;

        for(int j = k; j < slen; j++){
            numVowelsInSubstring = numVowelsInSubstring - isVowel(s.charAt(j-k)) + isVowel(s.charAt(j));

            maxNumVowels =  Math.max(maxNumVowels, numVowelsInSubstring);
        }
        return maxNumVowels;
    }

    private static int isVowel(char vowel){
        return (vowel == 'a' || vowel == 'e' || vowel == 'i' ||vowel == 'o' || vowel == 'u') ? 1:0;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
