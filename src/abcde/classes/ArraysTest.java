package abcde.classes;

import java.util.Arrays;

public class ArraysTest {

    public void arraysIntro(){
        char[] bug ="bugs".toCharArray();
        String[] bugs = {"cricket", "beetle", "ladybug"};
        String[] alias = bugs;
        System.out.println(bugs.equals(alias));
        System.out.println(Arrays.toString(alias));
        //sorting
        String[] numbers = {"10","9", "100"};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public void binarySearching(){
        //binary search
        int[] nums = {2, 3, 5, 6, 8, 9};
        System.out.println(Arrays.binarySearch(nums,1));
        System.out.println(Arrays.binarySearch(nums,4));
        System.out.println(Arrays.binarySearch(nums,8));
        System.out.println(Arrays.binarySearch(nums,10));
    }
    public void comparing(){
        //comparing length of array and their elements
        //if arrays have different elements but same length, the result of comparing will be negative number
        System.out.println(Arrays.compare(new int[]{1}, new int[]{2}));//negative one
        //if length is the same and elements are the same also, the seult will be zero.
        // so zero means equality between the arrays.
        System.out.println(Arrays.compare(new int[]{2}, new int[]{2}));//zero
        //if first array is larger than second array, and they have same elements,
        // the result will be positive
        System.out.println(Arrays.compare(new int[]{1,2,3,4}, new int[]{1,2,3})); //positive
        //second is larger than first array, result will be the number of elements different between arrays.
        System.out.println(Arrays.compare(new int[]{1,2,3}, new int[]{1,2,3,4,5}));
        //JAva is looking for the last element from first array in second array
        // the ellements take into account are 1,2,3, the others not.
        // so for that reason the result is 1
        System.out.println(Arrays.compare(new int[]{1,2,3,8}, new int[]{1,2,3,5,6,7}));
    }

    public void calculating(){
        double c = Math.ceil(3.5);
        double v = Math.floor(3.5);
        System.out.println(c+" "+v);
        double squared = Math.pow(4, 3);
        System.out.println(squared);
        System.out.println(Math.random());// value minor than 1 and major than 0
    }
    public static void main(String[] args) {
        ArraysTest at = new ArraysTest();
        // at.arraysIntro();
        //at.binarySearching();
        //at.comparing();
        at.calculating();
    }
}
