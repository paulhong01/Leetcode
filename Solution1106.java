// Leetcode 1106: Parsing A Boolean Expression
import java.util.*;

class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> operands = new Stack();
        Stack<Character> operators = new Stack();
        for (char c : expression.toCharArray()) {
            if (c == ',')   continue;
            else if (c == '(' || c == 'f' || c == 't') {
                operands.push(c);
            } else if (c == ')') {
                List<Character> list = new ArrayList();
                while (!operands.isEmpty() && operands.peek() != '(') {
                    list.add(operands.pop());
                }
                char operator = operators.pop();
                boolean temp_result = eval(operator, list);
                if (!operands.isEmpty())    operands.pop();
                operands.push((temp_result?'t':'f'));
            } else if (c == '|' || c == '!' || c == '&') {
                operators.push(c);
            }
        }
        return operands.pop()=='t'?true:false;
    }
    
    private boolean eval(char operator, List<Character> list) {
        int tcount = 0;
        for (char c : list) {
            if (c == 't')   tcount++;
            if (operator == '!' && c == 't')    return false;
            if (operator == '!' && c == 'f')    return true;
            if (operator == '&' && c == 'f')    return false;
        }
        return tcount > 0?true:false;
    }
}