package daily.code.bitman;

public class AddNumbers {

    /**
     * function to add two
     * */
    private static String addNumbers(String str1, String str2){
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int a = str1.length()-1, b = str2.length()-1;
        while(a >= 0 || b >= 0){
            int sum = carry;
            if(a >= 0){
                sum += str1.charAt(a--)-'0';
            }
            if(b >= 0){
                sum += str2.charAt(b--)-'0';
            }
            res.insert( 0,sum%10);
            carry  = sum/10;
        }
        if(carry > 0){
            res.insert(0,1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(addNumbers("123456789012345678901", "12345678"));
        System.out.println(addNumbers("134", "11"));
    }

        /***
                 123456789012345678901
                              12345678
                 ----------------------
                 123456789012358024579
        ***/
}
