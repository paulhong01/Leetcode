// Leetcode 1353: Maximum Number of Events That Can Be Attended
import java.util.*;

class Solution1353 {
    public int maxEvents(int[][] A) {
        // TC:O(NlogN), SC:O(N)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = A.length;
        for (int d = 1; d <= 100000; ++d) {
            while (pq.size() > 0 && pq.peek() < d)
                pq.poll();
            while (i < n && A[i][0] == d)
                pq.offer(A[i++][1]);
            if (pq.size() > 0) {
                pq.poll();
                ++res;
            }
        }
        return res;
    }
}