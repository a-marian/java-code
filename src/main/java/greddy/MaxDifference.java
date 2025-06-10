package greddy;

public class MaxDifference {

    public static int maxDifference(String s) {
        int[] letters = new int[26];
        for(char l: s.toCharArray()){
            letters[l-'a']++;
        }
        int maxOdd = 1, minEven = Integer.MAX_VALUE;
        for(int i=0; i < letters.length; i++){
            System.out.println("letters["+letters[i] + "]");
            if(letters[i] > 0 && letters[i] % 2 == 0 ){
                minEven = Math.min(minEven, letters[i]);

            } else {
                maxOdd = Math.max(maxOdd, letters[i]);
            }
        }
        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        System.out.println(maxDifference("abcabcab"));
    }
}
