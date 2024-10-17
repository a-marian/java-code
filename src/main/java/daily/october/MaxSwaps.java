package daily.october;
/**
 * https://leetcode.com/problems/maximum-swap/description/
 * 670. Maximum Swap
 * Python solution
 * class Solution:
 *     def maximumSwap(self, num: int) -> int:
 *         digits = list(str(num))
 *
 *         # create an array to store the last ocurrence of each digit
 *         last = {int(digit): i for i, digit in enumerate(digits)}
 *
 *         # Traverse the digits and try to find a larger digit to swap
 *         for i, digit in enumerate(digits):
 *             for d in range(9, int(digit), -1):
 *                 if last.get(d, -1) > i:
 *                     # swap the digits
 *                     digits[i], digits[last[d]]= digits[last[d]], digits[i]
 *
 *                     #convert the list of digits back to an integer and return it
 *                     return int("".join(digits))
 *         # if no swap was made, return the original number
 *         return num
 *
 * Java sol
 * */
public class MaxSwaps {

    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] nums = str.toCharArray();
        //create an array to store the last ocurrence of each digit
        int[] last = new int[10];

        //fill the array with the last ocurrence index of each digit
        for(int i=0; i < nums.length; i++){
            last[nums[i]-'0']=i;
        }
        // Traverse the digits and try to find a larger digit to swap
        for(int i=0; i < nums.length; i++){
            for(int d =9; d > nums[i]-'0'; d--){
                if(last[d] > i){
                    //swap the digits
                    char temp = nums[i];
                    nums[i] = nums[last[d]];
                    nums[last[d]] = temp;

                    //convert the char array back to an integer and return it
                    return Integer.parseInt(new String(nums));
                }
            }
        }
        // if no swap was made, return the original number
        return num;
    }
}
