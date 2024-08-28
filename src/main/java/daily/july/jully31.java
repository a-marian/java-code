package daily.july;

import java.util.Arrays;

public class jully31 {

    public static void main(String[] args) {
            int a1[] = {1,2,3,4};
            int a2[] = {2, 4, 1, 3};
            int a3[] = {3, 8, 19, 39, 56};

        System.out.println("Arrays.compare(a1, a2) = " + Arrays.compare(a1, a2));
       // System.out.println("Arrays.compare(a1, a2) = " + Arrays.compare(a3, a2));
        System.out.println("Arrays.compare(a1, a2) = " + Arrays.mismatch(a1, a2));
     //   System.out.println("Arrays.compare(a1, a2) = " + Arrays.mismatch(a2, a1));

        System.out.println(Arrays.compare(a1, a2));

    }

}
