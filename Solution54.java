// Leetcode 54: Spiral Matrix
import java.util.*;

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if (matrix == null || matrix.length == 0)     return result;
        
        int m = matrix.length, n = matrix[0].length;
        int sr = 0, sc = 0;
        while (sr < m && sc < n) {
            for(int i = sc; i < n; i++)    result.add(matrix[sr][i]);
            sr++;
            
            for(int i = sr; i < m; i++)    result.add(matrix[i][n-1]);
            n--;
            
            if (sr < m) {
                for(int i = n - 1; i >= sc; i--)    result.add(matrix[m-1][i]);
                m--;
            }
            
            if (sc < n) {
                for (int i = m-1; i >= sr; i--) result.add(matrix[i][sc]);
                sc++;
            }
        }
        return result;
    }
}