// Leetcode 85: Maximal Rectangle
import java.util.*;

class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        // Method 1 : Brute force, TC:O(N^2M^2), SC:O(1)
        // int result = 0;
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if (matrix[i][j] == '1') {
        //             result = Math.max(result, helper(matrix, i, j));
        //         }
        //     }
        // }
        // return result;

        // Method 2: Using stack, TC:O(NM), SC:O(M), where N = matrix.length, M = matrix[0].length
        if (matrix.length == 0) return 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int[] dp = new int[M];
        int result = 0;
        for (int i = 0; i < N; i++) {
            // Update height
            for (int j = 0; j < M; j++) {
                dp[j] = matrix[i][j] == '0'?0:dp[j]+1;
            }
            
            Stack<Integer> stack = new Stack();
            stack.push(-1);
            for (int j = 0; j < M; j++) {
                while (stack.peek() != -1 && dp[stack.peek()] > dp[j]) {
                    result = Math.max(result, dp[stack.pop()] * (j-stack.peek()-1));
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                result = Math.max(result, dp[stack.pop()] * (M-stack.peek()-1));
            }
        }
        return result;
    }
    
    private int helper(char[][] matrix, int row, int col) {
        int result = 1;
        int max_row = matrix.length;
        int max_col = matrix[0].length;
        for (int i = row; i < max_row; i++) {
            int j = col;
            // System.out.printf("%d %d %d\n", i, j, result);
            if (matrix[i][col] == '0')  break;
            for (j = col; j < max_col; j++) {
                if (matrix[i][j] == '0') {
                    max_col = j;
                    break;
                }
                result = Math.max(result, (j-col+1)*(i-row+1));
            }
        }
        System.out.println(result);
        return result;
    }
}