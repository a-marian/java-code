package greddy;

public class BitonicProblem {


    public static int bitonic(int[]arr){
        int left=0, right=arr.length-1;
        while (left <= right){
            int mid = left+(right-left)/2;

            if(left == right){
                return arr[left];
            }

            if((right == left +1) && arr[left] >= arr[right])
                return arr[left];

            if((right == left+1) && arr[left] < arr[right])
                return arr[right];

            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
                return arr[mid];

            if(arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1])
                right = mid -1;
            else
                left = mid +1;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = new int[]{1,3,50,10,9,7,6,42};
        System.out.println(bitonic(arr));

        int[]arr2 = new int[]{4,2,3,5,1};
        System.out.println(bitonic(arr2));
    }
}
