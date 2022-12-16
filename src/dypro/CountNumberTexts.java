package dypro;

public class CountNumberTexts {

    public static int countTextsTabulation(String pressedKeys) {
        int mod = 1000000007;
        int[] key = new int[] { 0, 0, 3, 3, 3, 3, 3, 4, 3, 4 };
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int ind = n - 1; ind >= 0; ind--) {
            int count = 0;
            int num = pressedKeys.charAt(ind) - '0';
            int rep = key[num];
            for (int i = 0; i < rep && ind + i < pressedKeys.length() && pressedKeys.charAt(ind) == pressedKeys.charAt(ind + i); i++) {
                count += dp[ind+i+1];
                count %= mod;
            }
            dp[ind] = count;
        }
        return dp[0];
    }

    public static int countTexts(String pressedKeys) {

        int MOD = 1000000007;

        if(pressedKeys.length() == 1) return 1;
        int[]numbers = new int[10];

        for (int i = 0; i < pressedKeys.length(); i++) {
            int val = pressedKeys.charAt(i) - '0';
            numbers[val]++;
        }
        int texts =0;
        for (int i = 2; i < numbers.length ; i++) {
            int res = 1;
            if(numbers[i] > 1){

                for (int j = numbers[i]; j > 1 ;  j--) {
                    res *=j;
                    res %= MOD;
                }
                texts += res;
            }else{}
        }

        return texts;
    }

    public static void main(String[] args) {
        System.out.println(countTexts("22233"));
        System.out.println(countTexts("23456789"));

     //   System.out.println(countTextsTabulation("222222222222222222222222222222222222"));



    }
}
