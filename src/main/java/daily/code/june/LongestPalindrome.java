package daily.code.june;

/**
 * https://leetcode.com/problems/longest-palindrome/
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
 * that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * */

public class LongestPalindrome {

        public static int longestPalindrome(String s) {
            int[]memo = new int[128];
            int res=0;
            for(char a: s.toCharArray()){
                if(++memo[a] == 2){
                    res +=2;
                    memo[a] = 0;
                }
            }
            return (res == s.length())? res: res+1;
        }

    public int longestPalindromeV2(String s) {
        int[] memo = new int[128];
        for (char c: s.toCharArray()) {
            memo[c]++;
        }
        int res = 0;
        for (int i: memo) {
            res += i/2*2;
            if(res%2 == 0 && i % 2 == 1)
                res++;
        }
        return res;
    }


    public static void main(String[] args) {
        String word="abccccdd";
        String rr = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(word));
    }
   }

   /**
    * Python 3
    *
    *class Solution:
    *     def longestPalindrome(self, s: str) -> int:
    *         memo = [0] * 128
    *         res = 0
    *         for char in s:
    *             memo[ord(char)] += 1
    *             if memo[ord(char)] == 2:
    *                 res += 2
    *                 memo[ord(char)] = 0
    *         return res if res == len(s) else res + 1
    * **/
