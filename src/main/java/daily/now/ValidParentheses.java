package daily.now;

/**
 *  Parentheses - LeetCode
 *  https://leetcode.com/problems/valid-parentheses/description/
 *  */
public class ValidParentheses {
    public boolean isValid(String s){
        int n = s.length();
        if(n % 2 != 0) return false;

        char[] stack = new char[n];
        int top = -1;

        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack[++top] = c;
            } else {
                if(top == -1) return false;
                char open = stack[top--];

                if((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '[' )){
                    return false;
                }
            }
        }
        return top == -1;
    }
}
