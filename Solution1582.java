// Solution 1582: Special Positions in a Binary Matrix
import java.util.*;

class Solution1582 {
    public int numSpecial(int[][] mat) {
        // TC:O(NM), SC:(NM), where N = mat.length, M = mat[0].length
        int ret = 0;
        Map<Integer, Integer> row_count = new HashMap<>();
        Map<Integer, Integer> col_count = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row_count.put(i, row_count.getOrDefault(i, 0)+1);
                    col_count.put(j, col_count.getOrDefault(j, 0)+1);
                }
            }
        }
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row_count.get(i) == 1 && col_count.get(j) == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }
}
