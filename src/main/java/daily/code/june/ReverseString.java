package daily.code.june;

import java.util.Arrays;

/**
 * Leetcode: 344. Reverse String
 * */
public class ReverseString {

    public static void reverseString(char[] s) {
        int len = s.length;

        int left=s.length-1;
        int right=0;
        char temp = 'a';
        while(left >=  right){
            temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            right++;
            left--;
        }
    }

    public static void main(String[] args) {
        char[] arr= {'h','e','l','l','o'};
        reverseString(arr);
        Arrays.asList(arr).forEach(System.out::print);
    }
}

/*** Python 3
 * class Solution:
 *     def reverseString(self, s: List[str]) -> None:
 *         """
 *         Do not return anything, modify s in-place instead.
 *         """
 *         left = len(s) - 1
 *         right= 0
 *         while(left >= right):
 *             temp= s[right]
 *             s[right] = s[left]
 *             s[left] = temp
 *             right+=1
 *             left -=1
 */

