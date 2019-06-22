// Leetcode 227: Basic Calculator II
import java.util.*;

class Solution227 {
    public int calculate(String s) {
        // TC:O(N), SC:O(N)
        s = s.trim();
        String[] num = s.split("[ +-/*]+");
        List<Integer> num_list = new ArrayList();
        for (String n: num) {
            num_list.add(Integer.valueOf(n));
        }
        List<Character> op_list = new ArrayList();
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                op_list.add(c);
            }
        }
        
        int idx = 0;
        while(idx < op_list.size()) {
            if (op_list.get(idx) == '*' || op_list.get(idx) == '/') {
                System.out.println(idx);
                int num1 = num_list.get(idx), num2 = num_list.get(idx+1);
                System.out.printf("%d %d\n", num1, num2);
                int temp_result = op_list.get(idx)=='*'?(num1*num2):(num1/num2);
                num_list.remove(idx);
                num_list.remove(idx);
                op_list.remove(idx);
                num_list.add(idx, temp_result);
            } else {
                idx++;
            }
        }
        idx = 0;
        while(idx < op_list.size()) {
            if (op_list.get(idx) == '+' || op_list.get(idx) == '-') {
                int num1 = num_list.get(idx), num2 = num_list.get(idx+1);
                int temp_result = op_list.get(idx)=='+'?(num1+num2):(num1-num2);
                num_list.remove(idx);
                num_list.remove(idx);
                op_list.remove(idx);
                num_list.add(temp_result);
            } else {
                idx++;
            }
        }
        return num_list.get(0);
    }
}