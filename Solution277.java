// Leetcode 277: Find the Celebrity
import java.util.*;

public class Solution277 extends Relation {
    public int findCelebrity(int n) {
        int[] in_degree = new int[n];
        int[] out_degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    in_degree[j]++;
                    out_degree[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (in_degree[i] == n && out_degree[i] == 1) return i;
        }
        return -1;
    }
}