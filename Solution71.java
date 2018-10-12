// Leetcode 71: Simplify Path
import java.util.*;

public class Solution71 {
    public static void main(String[] args) {
        String path = "/home/";

        Solution71 sol = new Solution71();
        String res = sol.simplifyPath(path);
        System.out.println(res);
    }

    public String simplifyPath(String path) {
        // Split to String array
        String[] s_arr = path.split("/");
        
        Stack<String> stack = new Stack();
        for (String s: s_arr) {
            if (s.equals("") || s.equals(".") || (s.equals("..") && stack.isEmpty())) continue;
            else if (s.equals("..") && !s.isEmpty())    stack.pop();
            else stack.push(s);
        } 

        String result = "";
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }


        return result == ""?"/":result;
    }
}