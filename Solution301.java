// Leetcode 301: Remove Invalid Parentheses
import java.util.*;

public class Solution301 {
    public static void main(String[] args) {
        String s = "()())()";

        Solution301 sol = new Solution301();
        List<String> res = sol.removeInvalidParentheses(s);
        for (String r: res) {
            System.out.printf("%s ", r);
        }
        System.out.println("");
    }

    public List<String> removeInvalidParentheses(String s) {
        // BFS
        List<String> result = new ArrayList();

        Set<String> set = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.add(s);
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();

            boolean flag = false;
            if (isValid(cur)) {
                result.add(s);
                flag = true;
            }
            if (flag)   continue;

            for (int i = 0; i < )
            
        }
    }

    private boolean isValid(String s) {

    }
}