// Leetcode 1380: Lucky Numbers in a Matrix
import java.util.*;

class Solution1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // Two pass. TC:O(NM), SC:O(N+M), where N = matrix.length, M = matrix[0].length
        int N = matrix.length, M = matrix[0].length;
        int[] min = new int[N];
        Arrays.fill(min, Integer.MAX_VALUE);
        int[] max = new int[M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (min[i] == max[j]) {
                    ret.add(min[i]);
                }
            }
        }
        return ret;
    }
}