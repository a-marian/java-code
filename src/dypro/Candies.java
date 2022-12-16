package dypro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Candies
 * Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
 * All the children sit in a line and each of them has a rating score according to his or her performance in the class.
 * Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with
 * the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.
 * Example
 * arr= [4, 6, 4, 5, 6, 2]
 * She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1]. She must buy a minimum of 10 candies.
 * Function Description
 * Complete the candies function in the editor below.
 * Candies have the following parameter(s):
 * * int n: the number of children in the class
 * * int arr[n]: the ratings of each student
 * */

public class Candies {

    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        if(n == 0) return 0;
        int[] candyBox = new int[n];
        Arrays.fill(candyBox, 1);
        long candies = 0;
        for (int i = 0; i < n-1; i++) {
            if (arr.get(i+1) > arr.get(i)) {
                candyBox[i+1]= candyBox[i] +1;
            }
        }
        for (int i = n-1; i > 0; i--) {
            if((arr.get(i-1)> arr.get(i)) && (candyBox[i-1] <= candyBox[i])){
              candyBox[i-1]= candyBox[i] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            candies+=candyBox[i];
        }
        return candies;
    }
    private  static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = in.nextInt();
           arr.add(arrItem);
        }

        long res= candies(n, arr);
        System.out.println(res);
        in.close();

    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * https://www.hackerrank.com/challenges/candies/
 * */
