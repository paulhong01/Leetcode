// Leetcode 1029: Two City Scheduling
import java.util.*;

class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        // TC:O(Nlog(N)), SC:O(1)
        Arrays.sort(costs, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               int v1 = a[1] - a[0];
               int v2 = b[1] - b[0];
               return v1-v2;
           } 
        });
        
        int total_costs = 0;
        for (int[] cost: costs) {
            total_costs += cost[0];
        }
        
        for (int i = 0; i < costs.length/2; i++) {
            total_costs += costs[i][1] - costs[i][0];
        }
        return total_costs;
    }
}