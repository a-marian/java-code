package twopointers;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * "hello" --> Output: "holle"
 * */

public class ReverseVowelsInString {

    public static String reverseVowels(String s) {
        int len = s.length();
        int left = 0, right=len-1;
        char arr[] = s.toCharArray();
        char l = ' ', r = ' ';
        while(left <= right){
            if(isVowel(s.charAt(left))){
                l = s.charAt(left);
            }else{
                l = ' ';
                left++;
            }
            if(isVowel(s.charAt(right))){
                r = s.charAt(right);
            }else{
                r= ' ';
                right--;
            }
            if(r != ' ' && l != ' '){
                arr[left]=r;
                arr[right]=l;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    private static boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' ||ch == 'U');
    }

    public static void main(String[] args) {

        String s= "hello";
        System.out.println(reverseVowels(s));
        // "hello" -->  "holle"
    }
    /**
     * Time Complexity:
     *
     * */
}
