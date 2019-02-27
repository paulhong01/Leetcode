// Leetcode 997: Find the Town Judge
import java.util.*;

class Solution997 {
    public int findJudge(int N, int[][] trust) {
        if (N == 1 && trust.length == 0)    return 1;
        
        Map<Integer, Set> map = new HashMap();
        Set<Integer> trustlist = new HashSet();
        for (int[] t: trust) {
            if (!map.containsKey(t[1])) {
                map.put(t[1], new HashSet());
            }
            map.get(t[1]).add(t[0]);
            trustlist.add(t[0]);
        }
        
        for (int key: map.keySet()) {
            if (map.get(key).size() == N-1 && !trustlist.contains(key)) {
                return key;
            }
        }
        return -1;
    }
}