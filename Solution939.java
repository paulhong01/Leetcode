//Leetcode 939: Minimum Area Rectangle
import java.util.*;

class Solution939 {
    public static void main(String[] args) {
        int[][] points = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        Solution939 sol = new Solution939();
        int res = sol.minAreaRect(points);
        System.out.println(res);
    }

    public int minAreaRect(int[][] points) {
        // TC:O(n^2), SC:O(n)
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] p: points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet());
            }
            map.get(p[0]).add(p[1]);
        }
        
        int result = Integer.MAX_VALUE;
        for (int[] p1: points) {
            for (int[] p2: points) {
                if (p1[0] == p2[0] || p1[1] == p2[1])   continue;
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    result = Math.min(result, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        return result == Integer.MAX_VALUE?0:result;
    }
}