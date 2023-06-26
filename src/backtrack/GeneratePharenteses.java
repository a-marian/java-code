package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 * */
public class GeneratePharenteses {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backtracking(res, new StringBuilder(), 0, 0, n);
            return res;
        }

        private void backtracking(List<String> res, StringBuilder current, int left, int right, int len){
            if (current.length() == 2*len){
                res.add(current.toString());
                return;
            }

            if (left < len){
                current.append("(");
                backtracking(res, current, left+1, right, len);
                current.deleteCharAt(current.length()-1);
            }

            if(left > right){
                current.append(")");
                backtracking(res, current, left, right+1, len);
                current.deleteCharAt(current.length()-1);
            }



        }

}
