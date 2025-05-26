package daily.leader;

import java.util.Stack;

public class BaseballGame {

    public int callPoints(String[] operations){
        Stack<Integer> stack = new Stack<>();

        for (String op: operations) {
            if(op.equals("+")) {
                int last = stack.pop();
                int secondLast= stack.peek();
                int newScore = last + secondLast;
                stack.push(last);
                stack.push(newScore);
            } else if("D".equals(op)){
                stack.push(2* stack.peek());
            } else if ("C".equals(op)) {
                stack.pop();
            } else{
                stack.push(Integer.parseInt(op));
            }
        }

        int totalScore = 0;
        for(int score: stack){
            totalScore += score;
        }
        return totalScore;
    }

    public static void main(String[] args) {
        BaseballGame b = new BaseballGame();
        String[] operations={"5", "2", "C", "D", "+"};
        System.out.println(b.callPoints(operations));
    }
}
