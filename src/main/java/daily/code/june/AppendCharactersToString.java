package daily.code.june;

/**
 * 2486. Append Characters to String to Make Subsequence
 *
 * */

public class AppendCharactersToString {

    public static int appendCharacters(String s, String t) {
        int i=0, j=0;
        int s_len=s.length(), t_len= t.length();
        while(i < s_len && j < t_len){
            if (s.charAt(i)-'0' == t.charAt(j)-'0')
                j++;
            i++;
        }
        return t_len-j;
    }

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }

}

/***
 * Python3
 * class Solution:
 *     def appendCharacters(self, s: str, t: str) -> int:
 *         i, j = 0, 0
 *         len_s, len_t = len(s), len(t)
 *         while i < len_s and j < len_t:
 *             if s[i] == t[j]:
 *                 j +=1
 *             i += 1
 *
 *         return len_t - j
 * **/
