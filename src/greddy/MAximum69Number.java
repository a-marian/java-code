package greddy;

/**
 * https://leetcode.com/problems/maximum-69-number/
 * You are given a positive integer num consisting only of digits 6 and 9.
 *  Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *  Example 1:
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * 9999
 * */

public class MAximum69Number {

    public int maximum69Number (int num) {
        //store num in a new var to
        int numToCheck  = num;
        int indexSix  = -1;
        //since we start with the lowest digit, initialize currDigit=0
        int currDigit = 0;
        //check every digit of numToCheck from low to high.
        while( numToCheck > 0) {
            //if the current digit is 6 record it as the highest digit of 6.
            if(numToCheck % 10 == 6)
                indexSix = currDigit;
            //move on to the next digit.
            numToCheck /= 10;
            currDigit++;
        }
        // if we don't find any digit of '6' return the original number,
        // otherwise, increment 'num' by the difference made by the first '6'
        return indexSix == -1 ? num: num+3*(int)Math.pow(10, indexSix);
    }

    /**
     * Complexity Analysis:
     * Let L be the maximum numberof digits of 'num' can have (L=4 in this problem).
     * Time complexity O(L)
     *  We need to make at most L time of integer divisions, which takes O(L) time.
     *  Space compexity O(1)
     *  We only need to update several variables, which takes O(1) space
     */

}
