package dypro;

import java.util.Scanner;
/**
 * Abbreviation
 * You can perform the following operations on the string, a :
 * 1. Capitalize zero or more of a's lowercase letters.
 * 2. Delete all of the remaining lowercase letters in a.
 * Given two strings, a and b, determine if it's possible to make a equal b to  as described.
 * If so, print YES on a new line. Otherwise, print NO.
 * For example, given a= AbcDE and b= ABDE, in a we can convert b and delete c to match b.
 * If a= AbcDE and b= AFDE, matching is not possible because letters may only be capitalized or discarded, not changed.
 * Function Description
 * Complete the function to solve this issue. It must return either YES or NO.
 * abbreviation has the following parameter(s):
 * a: the string to modify
 * b: the string to match
 * **/
public class Abbreviation {

    public static String abbreviationV2(String a, String b){
        return "";
    }
    public static String abbreviation(String a, String b) {
        boolean[][] isValid = new boolean[a.length()+1][b.length()+1];
        isValid[0][0] = true;

        for (int i= 1; i <= a.length(); i++) {
            if (Character.isUpperCase(a.charAt(i - 1))) {
                isValid[i][0] = false;
            }
            else isValid[i][0] = true;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    isValid[i][j] = isValid[i-1][j-1];
                }else if (Character.toUpperCase(a.charAt(i-1))  ==  b.charAt(j-1)) {
                    isValid[i][j] = isValid[i-1][j-1] || isValid[i-1][j];
                }else if (Character.isUpperCase(a.charAt(i-1))) {
                    isValid[i][j] = false;
                }else {
                    isValid[i][j] = isValid[i-1][j];
                }
            }
        }
        return isValid[a.length()][b.length()]? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String b = sc.next();
        sc.close();
        System.out.println(abbreviation(a, b));

    }
}
/**
 *
 * https://www.hackerrank.com/challenges/abbr/problem
 * */
