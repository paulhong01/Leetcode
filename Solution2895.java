// Leetcode 2895: Minimum Processing Time

import java.util.Collections;
import java.util.List;

public class Solution2895 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        // TC:O(NLogN), SC:O(1)
        int N = processorTime.size();
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int max_time = processorTime.get(N-1) +tasks.get(3);
        for (int i = N - 2; i >= 0; i--) {
            max_time = Math.max(max_time, processorTime.get(i) + tasks.get((N-1-i)*4+3));
        }
        return max_time;
    }
}
