// Leetcode 1817: Finding the Users Active Minutes
import java.util.*;

class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // TC:O(N), SC:O(N)
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] log : logs) {
            if (!map.containsKey(log[0])) {
                map.put(log[0], new HashSet<Integer>());
            }
            map.get(log[0]).add(log[1]);
        }
        
        int[] ret = new int[k];
        Arrays.fill(ret, 0);
        for (int key : map.keySet()) {
            int value = map.get(key).size() - 1;
            if (value < k) {
                ret[value]++;
            }
        }
        return ret;
    }
}