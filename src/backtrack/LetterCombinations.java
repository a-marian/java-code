package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {

        LinkedList<String> result =  new LinkedList<>();
        if (digits.length() == 0 ) return result;
        result.add("");

        String[] digit_map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0; i < digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length() == i){
                String permutation = result.remove();
                for(char c: digit_map[index].toCharArray()){
                    result.add(permutation+c);
                }
            }
        }

        return result;
        // backtracking(result, new StringBuilder(), 0, 0,)
    }
    public static List<String> letterCombinationsOptimus(String digits) {

        List<String> result =  new ArrayList<>();
        if (digits.length() == 0 ) return result;

        String[] digit_map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for(int i = 0; i < digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));
            backtracking(result, digits, new StringBuilder(), 0, digit_map);
        }

        return result;
    }
    private static void backtracking(List<String> result, String digits, StringBuilder current, int index, String[] mapping){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index)-'0'];
        for(int i=0; i<letters.length(); i++){
            backtracking(result, digits, current.append(letters.charAt(i)), index+1, mapping);
        }
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("23");
        res.forEach(System.out::println);
    }
}
