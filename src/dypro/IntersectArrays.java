package dypro;

import java.util.*;

public class IntersectArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List ans = new ArrayList();
        int left = 0, right = 0;
        while(left<nums1.length && right<nums2.length){
            if(nums1[left]<nums2[right]){left++;}
            else if(nums1[left]>nums2[right]){right++;}
            else{
                ans.add(nums1[left]);
                left++;right++;
            }
        }
        return ans.stream().mapToInt(a->(int)a).toArray();
    }



    private static int[] findIntersect(int left, int right, int[]find, int[]array){
        Hashtable set = new Hashtable();
        while (set.size() <= find.length && left < find.length && right >= 0){
            if (find[left] == array[right]){
                    set.put(left,find[left]);
                left++;
                right=array.length-1;
            }else{
                right--;
            }
        }
        return set.values().stream().mapToInt(a-> (int)a).toArray();
    }

    public static void main(String[] args) {
       // int[] arr1 = new int[]{4,9,5};
       // int[]arr2 = new int[]{9,4,9,8,4};
       // int[] arr1 = new int[]{1,2};
        //int[]arr2 = new int[]{1,1};
      //  int[] arr1 = new int[]{1,2,2,3};
      //  int[]arr2 = new int[]{2,2};
         int[] arr1 = new int[]{1,2};
        int[]arr2 = new int[]{1,1};

        for (int a:  intersect(arr1, arr2)) {
            System.out.print(" "+a);
        }
    }
}
