package daily.october;

public class DivideIntervals {
    public static int minGroups(int[][] intervals) {
        for (int i=0; i <intervals.length; i++){
           sort(intervals);
        }

        for (int[] i: intervals) {
            System.out.println(i[0]+" "+i[1]);
        }
        return 0;
    }

    private static void sort(int arr[][]){
        int n=arr.length;
        //build max heap
        for(int i=n/2-1; i>=0; i--){
            heapify(arr,n,i);
        }
        for(int i=n-1; i>0;i--){
            int temp =arr[0][1];
            arr[0][1] = arr[i][1];
            arr[i][1] = temp;
            //heapify to reduce the heap
            heapify(arr, i,0);
        }
    }

    private static void heapify(int arr[][], int n, int i){
        int largest=i;
        int left= 2*i+1;
        int right=2*i+2;

        if(left < n && arr[left][1] > arr[largest][1]){
            largest= left;
        }
        if(right < n && arr[left][1] > arr[largest][1]){
            largest = right;
        }

        if(largest != i){
            int swap=arr[i][1];
            arr[i][1]=arr[largest][1];
            arr[largest][1]=swap;
        //recursively heapify the affected subtree
            heapify(arr, n, largest);
        }

    }

    public static void main(String[] args) {

        int[][] intervals={{5,10},{6,8},{1,5},{2,3},{1,10}};
        int[][] intervals2= {{1,3},{5,6},{8,10},{11,13}};
        System.out.println(minGroups(intervals));
    }
}
