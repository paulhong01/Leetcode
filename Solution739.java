//Leetcode 739: Daily Temperatures
import java.util.*;

public class Solution739{
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution739 sol = new Solution739();
        int[] res = sol.dailyTemperatures(temperatures);
        for (int r: res) {
            System.out.printf("%d ", r);
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // TC:O(n), SC:O(n), where n = temperatures.length
        Stack<Integer> stack = new Stack();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])    stack.pop();
            result[i] = (stack.isEmpty())?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
         
    }
}