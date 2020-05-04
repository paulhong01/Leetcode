// Leetcode 1423: Maximum Points You Can Obtain from Cards
import java.util.*;

class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        // TC:O(N), SC:O(1)
        int N = cardPoints.length;
        int len = N - k;
        
        int min_subsum = 0;
        int cur_sum = 0;
        int total_sum = 0;
        for (int i = 0; i < len; i++) {
            cur_sum += cardPoints[i];
            total_sum += cardPoints[i];
        }
        min_subsum = cur_sum;
        
        for (int i = len; i < N; i++) {
            cur_sum = cur_sum + cardPoints[i] - cardPoints[i-len];
            min_subsum = Math.min(min_subsum, cur_sum);
            total_sum += cardPoints[i];
        }
        return total_sum - min_subsum;
    }
}