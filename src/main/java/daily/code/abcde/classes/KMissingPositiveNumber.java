package abcde.classes;

public class KMissingPositiveNumber {

        public  static int findKthPositive(int[] arr, int k) {
            int[] karr = new int[k*k];
            int kele = 0;
            int kont = 0;
            for (int i=0; i < arr.length; i++){
               kele +=1;
                    while(kele < arr[i]){
                        karr[kont] = kele++;
                        if(kont == k-1) return karr[kont];
                        kont++;
                    }
            }
            if(kont == 0){
                kele = arr[arr.length-1];
                for (int i = 0; i < k; i++) {
                    karr[i] = kele+1;
                }
            }
            if(kont < k){
                kele = arr[arr.length-1];
                while(kont <k){
                    karr[kont] = ++kele;
                    kont++;
                }
            }
        return karr[k-1];

           // return search(karr, k-1, 0, karr.length-1);

        }


        public int findKthPositiveV2(int[] arr, int k) {
            int start =0;
            int end = arr.length;
            while(start<end){
                int mid = start+(end-start)/2;
                if(arr[mid]-(mid+1)>=k){
                    end = mid;
                } else {
                    start = mid+1;
                }
            }
            return start+k;
        }


        private static int search(int[] arr, int k, int beg, int end){
            int mid = 0;
            while(beg <= end){
                    mid = beg + (end - beg)/2;
                if(mid == k)
                    return mid;
                if(mid > k)
                    beg = mid+1;
                else
                    end = mid-1;
            }
            return mid;
        }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,8,9};
        int k = 9;
        // int[] arr = new int[]{2,3,4,7,11};
        //int k = 5;
        System.out.println(findKthPositive(arr, k ));
    }

}
