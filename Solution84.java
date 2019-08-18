// Leetcode 84: Largest Rectangle in Histogram
import java.util.*;

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        // Method 1: Brute force, TC:O(N^2), SC:O(1)
        // int result = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     int min_height = Integer.MAX_VALUE;
        //     for (int j = i; j < heights.length; j++) {
        //         min_height = Math.min(min_height, heights[j]);
        //         result = Math.max(result, min_height*(j-i+1));
        //     }
        // }
        // return result;
        
        // Method 2: Using Stack, TC:O(N), SC:O(N)
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                result = Math.max(result, heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            result = Math.max(result, heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return result;
    }
}