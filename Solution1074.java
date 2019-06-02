// Leetcode 1074: Number of Submatrices That Sum to Target
import java.util.*;

class Solution1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // TC:O(m*n), SC:O(m)
        int m = matrix.length;
        int n = matrix[0].length;
        int[] array = new int[m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(array, 0);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    array[k] += matrix[k][j];
                }
                result += subArraySum(array, target);
            }
        }
        return result;
    }
    
    private int subArraySum(int[] array, int target) {
        int m = array.length;
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for (int i = 0; i < m; i++) {
            sum += array[i];
            if (map.containsKey(sum-target)) {
                result += map.get(sum-target);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}