package greddy;

import java.util.Arrays;

public class MinimumAverageDifference {

    public static int minimumAverageDifference(int[] nums) {
        if(nums.length == 1) return nums[0];

        int average = 0, minAverage = Integer.MAX_VALUE, cont=0, sumPartial=0, len= nums.length;
        int sumAll = Arrays.stream(nums).reduce((x, y) -> x + y).getAsInt();
        int indexMinAverage = 0;
        for(int i=0; i<nums.length; i++ ){
            cont++;
            sumPartial += nums[i];
            int all = (len != cont) ? (sumAll-sumPartial)/(len-cont) : 0;
            average = Math.abs(sumPartial/cont - all);
            if(minAverage > average){
                minAverage = average;
                indexMinAverage=i;
            }
        }
        return indexMinAverage;
    }

    public int minimumAverageDifferenceV2(int[] nums) {
        long min = Integer.MAX_VALUE, sum = 0;
        for (int i : nums) sum += i;
        int leftIndex = 0, resultIndex = -1;
        long prefixSum = 0;

        while (leftIndex < nums.length) {
            prefixSum += nums[leftIndex];
            long leftAverage = prefixSum / (leftIndex + 1);
            long sumRight = sum - prefixSum;
            if (sumRight != 0) sumRight /= nums.length - leftIndex - 1;
            long res = Math.abs(leftAverage - sumRight);
            if (res < min) {
                min = res;
                resultIndex = leftIndex;
            }
            leftIndex++;
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        int[] arr= {2,5,3,9,5,3};
        System.out.println(minimumAverageDifference(arr));

        int[] arr1= {0,4,3,0,0};
        System.out.println(minimumAverageDifference(arr1));

    }

}
