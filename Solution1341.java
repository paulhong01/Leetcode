// Leetcode 1341: The K Weakest Rows in a Matrix
import java.util.*;


class Solution1341 {
    public int[] kWeakestRows(int[][] mat, int k) {
        // TC:O(Nlog(N)), SC:O(N)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               if (a[1] != b[1]) {
                   return a[1] - b[1];
               } else {
                   return a[0] - b[0];
               }
           } 
        });
        
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    break;
                } else {
                    count++;
                }
            }
            int[] temp = {i, count};
            pq.add(temp);
        }
        
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}